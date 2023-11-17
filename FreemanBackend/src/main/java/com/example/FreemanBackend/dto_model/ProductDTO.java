package com.example.FreemanBackend.dto_model;

import com.example.FreemanBackend.model.Category;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductDTO {
    public Integer id;
    public String name;
    public String imagePath;
    public String description;
    public Double price;
    public Integer stock;
    public Double discountedPrice;

    public UserDTO userDTO;
    public Category category;
}
