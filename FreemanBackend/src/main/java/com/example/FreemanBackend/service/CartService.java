package com.example.FreemanBackend.service;

import com.example.FreemanBackend.model.Cart;
import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.repository.CartRepository;
import com.example.FreemanBackend.repository.ProductRepository;
import com.example.FreemanBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart insertItemToCart(Integer productId, Integer userId) {
        Product product = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (product == null || user == null) {
            return null;
        }

        Cart cart = cartRepository.findByUser(user);
        if (cart == null) {
            cart = new Cart();
        }

        cart.products.add(product);
        return cartRepository.save(cart);
    }

    public Cart removeItemFromCart(Integer productId, Integer userId) {
        Product product = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (product == null || user == null) {
            return null;
        }

        Cart cart = cartRepository.findByUser(user);
        if (cart != null) {
            cart.products.remove(product);
            return cartRepository.save(cart);
        }

        return null;
    }

    public Set<Product> getAllProductsFromCart(Integer userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            return null;
        }
        Cart cart = cartRepository.findByUser(user);
        return cart.products;
    }
}
