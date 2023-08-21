package com.example.FreemanBackend.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseEntity {
    static public ResponseEntity<String> get(String message) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).header("errorMessage", message).build();
    }
}
