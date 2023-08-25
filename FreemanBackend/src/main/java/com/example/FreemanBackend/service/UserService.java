package com.example.FreemanBackend.service;

import com.example.FreemanBackend.model.Cart;
import com.example.FreemanBackend.model.Favourite;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.repository.CartRepository;
import com.example.FreemanBackend.repository.FavouriteRepository;
import com.example.FreemanBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FavouriteRepository favouriteRepository;

    public User insertUser(User user) {
        User savedUser = userRepository.save(user);

        Cart cart = new Cart();
        cart.user = savedUser;

        Favourite favourite = new Favourite();
        favourite.user = savedUser;

        cartRepository.save(cart);
        favouriteRepository.save(favourite);

        return savedUser;
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

}
