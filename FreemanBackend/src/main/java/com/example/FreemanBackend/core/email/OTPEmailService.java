package com.example.FreemanBackend.core.email;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
@Qualifier("OTPEmailService")
public class OTPEmailService implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private String authenticationKey = "-1";

    @Override
    public HashMap<String, String> sendEmail(String toEmail) {
        HashMap<String, String> response = new HashMap<>();
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(applicationEmail);
            helper.setTo(toEmail);
            helper.setSubject("Subject");

            helper.setText(getEmailContent(), true);
            mailSender.send(message);

            response.put("Success", "true");
            response.put("authenticationKey", authenticationKey);
        } catch (Exception e) {
            response.put("Success", "false");
            response.put("authenticationKey", "false");
        }

        return response;
    }

    @Override
    public String getEmailContent() {
        generateAuthenticationKey();
        return "<h2>Your One-Time Password</h2>" +
                "<p>Use the following one-time password to log in to your account:</p>" +
                "<p><strong>" + authenticationKey + "</strong></p>" +
                "<p>This password is valid for one use only and will expire in 5 minutes.</p>" +
                "<p>If you did not request this password, please contact us immediately.</p>" +
                "<p>Thank you,<br> Freeman Team</p>";
    }

    public void generateAuthenticationKey() {
        Random random = new Random();
        int randomNumber = random.nextInt(999999);
        authenticationKey = String.format("%06d", randomNumber);
    }
}
