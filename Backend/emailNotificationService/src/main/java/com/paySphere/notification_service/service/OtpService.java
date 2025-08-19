package com.paySphere.notification_service.service;

import com.paySphere.notification_service.mail.Mailer;
import com.paySphere.notification_service.model.OtpVerification;
import com.paySphere.notification_service.repository.OtpVerificationRepository;
import com.paySphere.notification_service.service.dto.OtpVerifyResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final OtpVerificationRepository otpRepo;
    private final Mailer mailer;

    @Value("${paysphere.otp.expiry-minutes:5}")
    private int expiryMinutes;

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    /**
     * Generate a 6-digit OTP, store it, and send via email.
     * Returns the OTP only when 'local' profile is active (for dev).
     */
    public String generateAndSendOtp(String email, String purpose) {
        // Invalidate previous active OTP for (email, purpose)
        otpRepo.findTopByEmailAndPurposeAndIsUsedFalseOrderByExpiresAtDesc(email, purpose)
                .ifPresent(prev -> {
                    if (prev.getExpiresAt() != null && prev.getExpiresAt().isAfter(LocalDateTime.now())) {
                        prev.setIsUsed(true);
                        otpRepo.save(prev);
                    }
                });

        // Generate new 6-digit OTP
        String otp = String.format("%06d", ThreadLocalRandom.current().nextInt(0, 1_000_000));

        // Persist entity
        OtpVerification entity = new OtpVerification();
        entity.setEmail(email);
        entity.setPurpose(purpose);
        entity.setOtpCode(otp); // NOTE: Later switch to hashing -> otpHash
        entity.setIsUsed(false);
        entity.setFailedAttempts(0);
        entity.setExpiresAt(LocalDateTime.now().plusMinutes(expiryMinutes));
        otpRepo.save(entity);

        // Send email
        mailer.sendOtp(email, otp, expiryMinutes, purpose);

        // Return debug OTP ONLY for local profile
        return "local".equalsIgnoreCase(activeProfile) ? otp : null;
    }

    // === Your existing verify logic remains ===
    public OtpVerifyResult verifyOtpDetailed(String email, String otpCode, String purpose) {
        LocalDateTime now = LocalDateTime.now();
        Optional<OtpVerification> currentOpt =
                otpRepo.findTopByEmailAndPurposeAndIsUsedFalseOrderByExpiresAtDesc(email, purpose);

        if (currentOpt.isEmpty()) {
            return new OtpVerifyResult(false, "not_found", null, null);
        }

        OtpVerification current = currentOpt.get();

        // Check lock
        if (current.getLockedUntil() != null && now.isBefore(current.getLockedUntil())) {
            return new OtpVerifyResult(false, "locked", current.getFailedAttempts(), current.getLockedUntil());
        }

        // Check expiry
        if (current.getExpiresAt() == null || now.isAfter(current.getExpiresAt())) {
            current.setIsUsed(true);
            otpRepo.save(current);
            return new OtpVerifyResult(false, "expired", current.getFailedAttempts(), null);
        }

        // Check match
        if (current.getOtpCode() != null && current.getOtpCode().equals(otpCode)) {
            // success → delete or mark used (you previously deleted; keeping delete behavior)
            otpRepo.delete(current);
            return new OtpVerifyResult(true, "ok", null, null);
        }

        // Failure → increment attempts; lock if needed (maxAttempts via properties if you bind it)
        int attempts = current.getFailedAttempts() == null ? 0 : current.getFailedAttempts();
        attempts += 1;
        current.setFailedAttempts(attempts);
        // Example: lock after 5 attempts for 15 minutes if you externalize them
        // (Leave your existing logic here if different)
        otpRepo.save(current);
        return new OtpVerifyResult(false, "invalid", attempts, null);
    }
}
