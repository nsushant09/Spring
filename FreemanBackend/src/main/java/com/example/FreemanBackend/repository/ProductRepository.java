package com.example.FreemanBackend.repository;

import com.example.FreemanBackend.model.Category;
import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByUser(User user);
    public List<Product> findByCategory(Category category);

//    Optional<Product> findProductWithUserAndCategory(@Param("id") Integer id);
}
