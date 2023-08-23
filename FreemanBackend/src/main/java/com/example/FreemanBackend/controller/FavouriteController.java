package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.core.ErrorResponseEntity;
import com.example.FreemanBackend.model.Favourite;
import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/favourite")
public class FavouriteController {

    @Autowired
    FavouriteService favouriteService;

    @PostMapping("/add")
    ResponseEntity<?> addItemToFavourite(@RequestParam("product_id") Integer productId, @RequestParam("user_id") Integer userId){
        Favourite favourite = favouriteService.insertItemToFavourite(productId, userId);
        if(favourite == null){
            return ErrorResponseEntity.get("Product or User not found");
        }
        return ResponseEntity.ok().body(favourite);
    }

    @PostMapping("/remove")
    ResponseEntity<?> removeItemFromFavourite(@RequestParam("product_id") Integer productId, @RequestParam("user_id") Integer userId){
        Favourite favourite = favouriteService.removeItemFromFavourite(productId, userId);
        if(favourite == null){
            return ErrorResponseEntity.get("Product or User not found");
        }
        return ResponseEntity.ok().body(favourite);
    }

    @GetMapping("/favourite_products")
    ResponseEntity<?> getAllProductsFromFavourite(@RequestParam("user_id") Integer userId){
        List<Product> products = favouriteService.getAllProductsFromFavourite(userId);
        return ResponseEntity.ok().body(products);
    }

}
