package com.example.FreemanBackend.model;

import com.example.FreemanBackend.core.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = Constants.PRODUCT_TABLE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String imagePath;
    public String description;
    public Double price;
    public Integer stock;
    public Double discountedPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    public Category category;

    public void convertToDTO() {
        if (this.user == null)
            return;

        this.user.convertToDTO();
    }
}
