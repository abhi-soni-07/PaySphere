package com.paySphere.notification_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "otp_verification")
@Getter @Setter @NoArgsConstructor
public class OtpVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String otpCode;
    private String purpose;
    private Boolean isUsed = false;
    private LocalDateTime expiresAt;

    // 🔽 NEW
    private Integer failedAttempts = 0;           // count wrong tries
    private LocalDateTime lockedUntil = null;     // if set, reject until this time
}
