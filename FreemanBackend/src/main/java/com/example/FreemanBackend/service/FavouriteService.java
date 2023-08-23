package com.example.FreemanBackend.service;

import com.example.FreemanBackend.model.Favourite;
import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.repository.FavouriteRepository;
import com.example.FreemanBackend.repository.ProductRepository;
import com.example.FreemanBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Favourite insertItemToFavourite(Integer productId, Integer userId) {
        Product product = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (product == null || user == null) {
            return null;
        }

        Favourite favourite = favouriteRepository.findByUser(user);
        if (favourite == null) {
            favourite = new Favourite();
        }

        favourite.products.add(product);
        return favouriteRepository.save(favourite);
    }

    public Favourite removeItemFromFavourite(Integer productId, Integer userId) {
        Product product = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (product == null || user == null) {
            return null;
        }

        Favourite favourite = favouriteRepository.findByUser(user);
        if (favourite != null) {
            favourite.products.remove(product);
            return favouriteRepository.save(favourite);
        }

        return null;
    }

    public List<Product> getAllProductsFromFavourite(Integer userId){
        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            return null;
        }
        Favourite favourite = favouriteRepository.findByUser(user);
        return favourite.products;
    }
}
