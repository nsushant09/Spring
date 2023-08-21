package com.example.FreemanBackend.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class EmailController {
    @Autowired
    @Qualifier("OTPEmailService")
    EmailService otpMailService;

    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, String>> sendOTPEmail(@RequestParam("email") String toEmail) {
        HashMap<String, String> mailResponse = otpMailService.sendEmail(toEmail);
        return new ResponseEntity<>(mailResponse, HttpStatus.OK);
    }
}