package com.example.FreemanBackend.model;

import com.example.FreemanBackend.core.Constants;
import jakarta.persistence.*;

@Entity
@Table(name = Constants.CATEGORY_TABLE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(unique = true)
    public String name;
    public String imagePath;
}
