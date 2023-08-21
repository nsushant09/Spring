package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.core.ErrorResponseEntity;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public ResponseEntity<?> insertUser(@RequestBody User user) {

        if(userService.existsByEmail(user.email))
            return ResponseEntity.badRequest().body("User with the provided email already exists");

        User responseUser = userService.insertUser(user);
        return ResponseEntity.ok(responseUser);
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User responseUser = userService.updateUser(user);
        return ResponseEntity.ok(responseUser);
    }

    @GetMapping("/by_user_detail")
    public ResponseEntity<?> getUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        if(!userService.existsByEmail(email))
            return ErrorResponseEntity.get("Invalid email");

        User responseUser = userService.getUser(email, password);
        if(responseUser == null)
            return ErrorResponseEntity.get("Invalid Password");

        return ResponseEntity.ok(responseUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

}
