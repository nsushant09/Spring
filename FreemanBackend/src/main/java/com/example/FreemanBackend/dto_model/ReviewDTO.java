package com.example.FreemanBackend.dto_model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReviewDTO {
    public Integer id;
    public String description;
    public Integer rating;
    public String date;
    public UserDTO userDTO;
}
