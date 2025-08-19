package com.paySphere.notification_service.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;

import lombok.Data;

@Data
public class OtpVerifyRequest {
    @NotBlank @Email
    private String email;

    @NotBlank
    private String purpose;

    @NotBlank
    private String otp; // must be present for verify
}
