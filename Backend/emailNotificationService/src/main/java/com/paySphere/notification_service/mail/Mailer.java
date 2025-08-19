package com.paySphere.notification_service.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mailer {
    private final JavaMailSender mailSender;

    public void sendPlain(String to, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(body);
        mailSender.send(msg);
    }

    public void sendOtp(String to, String otp, int validMinutes, String purpose) {
        String subject = "Your PaySphere OTP";
        String body = "Your OTP is: " + otp +
                "\nPurpose: " + purpose +
                "\nValid for: " + validMinutes + " minute(s)." +
                "\nIf you did not request this, please ignore.";
        sendPlain(to, subject, body);
    }
}
