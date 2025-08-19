package com.paySphere.notification_service.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class OtpVerifyResult {
    private boolean success;                // true if verified
    private String reason;                  // "ok", "invalid", "expired", "locked", "not_found"
    private Integer attemptsLeft;           // null when success/locked/not-found
    private LocalDateTime lockedUntil;      // set when locked
}

