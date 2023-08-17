package com.example.FreemanBackend.model;

import com.example.FreemanBackend.core.Constants;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = Constants.REVIEW_TABLE)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String description;
    public Integer rating;
    public Date date;
    public Integer userId;
}