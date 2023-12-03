package com.example.FreemanBackend.model;

import com.example.FreemanBackend.core.Constants;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = Constants.USER_TABLE)
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;

    @Column(unique = true)
    public String email;
    public String gender;
    public String password;
    public String phoneNumber;
    public Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    public Role role;
}
