package com.example.FreemanBackend.dto_model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class UserDTO {
    public Integer id;
    public String name;
    public String email;
    public String gender;
    public String phoneNumber;
    public String dateOfBirth;
    public String role;
}
