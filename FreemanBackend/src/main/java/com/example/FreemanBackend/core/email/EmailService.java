package com.example.FreemanBackend.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface EmailService {
    final String applicationEmail = "freemanurbanstore@gmail.com";

    HashMap<String, String> sendEmail(String toEmail);

    String getEmailContent();
}
