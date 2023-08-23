package com.example.FreemanBackend.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseEntity {
    static public ResponseEntity<String> get(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("errorMessage", message).build();
    }
}
