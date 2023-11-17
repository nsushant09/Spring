package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.dto_model.Mapper;
import com.example.FreemanBackend.dto_model.ReviewDTO;
import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.Review;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/")
    public ResponseEntity<Review> insertReview(@RequestParam("product_id") Integer productId, @RequestParam("user_id") Integer userId, @RequestBody Review review) {
        return ResponseEntity.ok(reviewService.insertReview(review, userId, productId));
    }

    @GetMapping("/all_by_product_id")
    public ResponseEntity<List<ReviewDTO>> getReviewsByProductId(@RequestParam("product_id") Integer product_id) {
        return ResponseEntity.ok(reviewService.findByProductId(product_id).stream().map(Mapper::toDto).collect(Collectors.toList()));
    }
}
