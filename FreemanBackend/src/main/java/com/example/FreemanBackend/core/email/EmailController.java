package com.example.FreemanBackend.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EmailController {
    @Autowired
    @Qualifier("OTPEmailService")
    EmailService otpMailService;

    @RequestMapping(value = "/mail/email={toEmail}", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, String>> sendEmail(@PathVariable String toEmail) {
        HashMap<String, String> mailResponse = otpMailService.sendEmail(toEmail);
        return new ResponseEntity<>(mailResponse, HttpStatus.OK);
    }
}
