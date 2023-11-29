package com.example.FreemanBackend.model;

import com.example.FreemanBackend.core.Constants;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@Entity
@Table(name = Constants.REVIEW_TABLE)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String description;
    public Integer rating;
    public String date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Product product;

}

/**
 * Model : Entity,
 * Controller : Handles Request
 * Services : Business Logic, Handles Data or Filters Data
 * Repository : Connects and fetches data from database
 */