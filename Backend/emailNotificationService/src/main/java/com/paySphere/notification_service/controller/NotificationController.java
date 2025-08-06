package com.paySphere.notification_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications/email")
public class NotificationController {

    @PostMapping("/user-registration")
    public ResponseEntity<String> sendWelcomeEmail() {
        return ResponseEntity.ok("Welcome email sent");
    }

    @PostMapping("/kyc-status")
    public ResponseEntity<String> sendKycStatusEmail() {
        return ResponseEntity.ok("KYC status email sent");
    }

    @PostMapping("/transaction-alert")
    public ResponseEntity<String> sendTransactionAlertEmail() {
        return ResponseEntity.ok("Transaction alert email sent");
    }

    @PostMapping("/password-reset")
    public ResponseEntity<String> sendPasswordResetEmail() {
        return ResponseEntity.ok("Password reset email sent");
    }

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtpEmail() {
        return ResponseEntity.ok("OTP email sent");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp() {
        return ResponseEntity.ok("OTP verified");
    }

    @PostMapping("/custom")
    public ResponseEntity<String> sendCustomEmail() {
        return ResponseEntity.ok("Custom email sent");
    }
}
