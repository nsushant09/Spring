package com.example.FreemanBackend.model;

import com.example.FreemanBackend.core.Constants;
import jakarta.persistence.*;

@Entity
@Table(name = Constants.USER_TABLE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String email;
    public String gender;
    public String password;
    public String phoneNumber;
    public String dateOfBirth;
    public String role;

    public void convertToDTO() {
        this.password = null;
        this.dateOfBirth = null;
        this.gender = null;
        this.role = null;
    }
}
