package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.core.ErrorResponseEntity;
import com.example.FreemanBackend.model.Cart;
import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.service.CartService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController{

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    ResponseEntity<?> addItemToCart(@RequestParam("product_id") Integer productId, @RequestParam("user_id") Integer userId){
        Cart cart = cartService.insertItemToCart(productId, userId);
        if(cart == null){
            return ErrorResponseEntity.get("Product or User not found");
        }
        return ResponseEntity.ok().body(cart);
    }

    @PostMapping("/remove")
    ResponseEntity<?> removeItemFromCart(@RequestParam("product_id") Integer productId, @RequestParam("user_id") Integer userId){
        Cart cart = cartService.removeItemFromCart(productId, userId);
        if(cart == null){
            return ErrorResponseEntity.get("Product or User not found");
        }
        return ResponseEntity.ok().body(cart);
    }

    @GetMapping("/cart_products")
    ResponseEntity<?> getAllProductsFromCart(@RequestParam("user_id") Integer userId){
        List<Product> products = cartService.getAllProductsFromCart(userId);
        return ResponseEntity.ok().body(products);
    }

}
