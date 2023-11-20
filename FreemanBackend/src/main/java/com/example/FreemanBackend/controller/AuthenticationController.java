package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.core.ErrorResponseEntity;
import com.example.FreemanBackend.dto_model.Mapper;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public ResponseEntity<?> signin(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (!userService.existsByEmail(email)) return ErrorResponseEntity.get("Invalid email");
        User user = userService.getUser(email, password);
        if (user == null) return ErrorResponseEntity.get("Invalid password");
        return ResponseEntity.ok(Mapper.toDTO(user, ""));
    }
}
