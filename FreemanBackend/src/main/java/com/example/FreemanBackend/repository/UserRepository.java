package com.example.FreemanBackend.repository;

import com.example.FreemanBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmailAndPassword(String email, String password);
    public Boolean existsByEmail(String email);
}
