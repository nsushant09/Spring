package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.Review;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/insert")
    public ResponseEntity<Review> insertReview(@RequestParam("product_id") Integer productId, @RequestParam("userId") Integer userId, @RequestBody Review review) {
        return ResponseEntity.ok(reviewService.insertReview(review, userId, productId));
    }

    @GetMapping("/all_by_product_id")
    public ResponseEntity<List<Review>> getReviewsByProductId(@RequestParam("product_id") Integer product_id){
        return ResponseEntity.ok(reviewService.findByProductId(product_id));
    }
}
