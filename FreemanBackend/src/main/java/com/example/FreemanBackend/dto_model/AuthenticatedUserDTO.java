package com.example.FreemanBackend.dto_model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticatedUserDTO {
    public Integer id;
    public String name;
    public String email;
    public String gender;
    public String phoneNumber;
    public String dateOfBirth;
    public String role;
    public String token;
}
