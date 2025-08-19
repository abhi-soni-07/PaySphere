package com.paySphere.notification_service.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OtpSendRequest {
    @NotBlank @Email
    private String email;

    @NotBlank
    private String purpose;
}
