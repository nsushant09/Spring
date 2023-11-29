package com.example.FreemanBackend.dto_model;

import com.example.FreemanBackend.model.Role;
import lombok.AllArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
public class AuthenticatedUserDTO {
    public Integer id;
    public String name;
    public String email;
    public String gender;
    public String phoneNumber;
    public Date dateOfBirth;
    public Role role;
}
