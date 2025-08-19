package com.paySphere.notification_service.repository;

import com.paySphere.notification_service.model.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpVerificationRepository extends JpaRepository<OtpVerification, Long> {

    Optional<OtpVerification> findByEmailAndOtpCodeAndPurposeAndIsUsedFalse(
            String email, String otpCode, String purpose);

    // 🔽 NEW: get the current OTP to bump attempts on wrong code
    Optional<OtpVerification> findTopByEmailAndPurposeAndIsUsedFalseOrderByExpiresAtDesc(
            String email, String purpose);
}
