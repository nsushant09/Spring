package com.example.FreemanBackend.repository;

import com.example.FreemanBackend.model.Cart;
import com.example.FreemanBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByUser(User user);
}
