package com.example.FreemanBackend.dto_model;

import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.Review;
import com.example.FreemanBackend.model.User;
import lombok.NoArgsConstructor;

import java.util.Map;

public class Mapper {
    public static UserDTO toDto(User user) {
        return new UserDTO(user.id, user.name, user.email, user.gender, user.phoneNumber, user.dateOfBirth, user.role);
    }

    public static ProductDTO toDto(Product product) {
        return new ProductDTO(product.id, product.name, product.imagePath, product.description, product.price, product.stock, product.discountedPrice, Mapper.toDto(product.user), product.category);
    }

    public static ReviewDTO toDto(Review review) {
        return new ReviewDTO(review.id, review.description, review.rating, review.date, Mapper.toDto(review.user));
    }

    public static AuthenticatedUserDTO toDTO(User user, String token) {
        return new AuthenticatedUserDTO(user.id, user.name, user.email, user.gender, user.phoneNumber, user.dateOfBirth, user.role, token);
    }
}
