package com.paySphere.notification_service.controller;

import com.paySphere.notification_service.controller.dto.OtpSendRequest;
import com.paySphere.notification_service.controller.dto.OtpVerifyRequest;
import com.paySphere.notification_service.service.OtpService;
import com.paySphere.notification_service.service.dto.OtpVerifyResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/notifications/email")
@RequiredArgsConstructor
public class NotificationController {

    private final OtpService otpService;

    @PostMapping(value = "/send-otp", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> sendOtp(@Valid @RequestBody OtpSendRequest req) {
        String debugOtp = otpService.generateAndSendOtp(req.getEmail(), req.getPurpose());
        if (debugOtp != null) {
            return ResponseEntity.ok(Map.of("status", "sent", "debugOtp", debugOtp));
        }
        return ResponseEntity.ok(Map.of("status", "sent"));
    }

    @PostMapping(value = "/verify-otp", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> verifyOtp(@Valid @RequestBody OtpVerifyRequest req) {
        OtpVerifyResult result = otpService.verifyOtpDetailed(req.getEmail(), req.getOtp(), req.getPurpose());
        if (result.isSuccess()) {
            return ResponseEntity.ok(Map.of("success", true, "message", "verified"));
        }
        return ResponseEntity.badRequest().body(Map.of(
                "success", false,
                "message", result.getReason(),
                "attempts", result.getAttemptsLeft(),
                "lockedUntil", result.getLockedUntil()
        ));
    }
}
