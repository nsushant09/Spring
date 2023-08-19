package com.example.FreemanBackend.service;

import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.Review;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequestMapping("/review")
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    public Review insertReview(Review review, Integer userId, Integer productId){
        User user =  userService.getUserById(userId);
        Product product = productService.getProductById(productId);
        review.user = user;
        review.product = product;
        return reviewRepository.save(review);
    }

    public List<Review> findByProductId(Integer productId){
        return reviewRepository.findByProductId(productId);
    }
}
