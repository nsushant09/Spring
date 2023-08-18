package com.example.FreemanBackend.service;

import com.example.FreemanBackend.model.Category;
import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.repository.ProductRepository;
import com.example.FreemanBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().peek(Product::convertToDTO).collect(Collectors.toList());
    }

    public Product getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            return null;
        product.get().convertToDTO();
        return product.get();
    }

    public List<Product> getProductByCategory(Category category) {
        return productRepository.findByCategory(category).stream().peek(Product::convertToDTO).collect(Collectors.toList());
    }

    public List<Product> getProductByUser(User user) {
        return productRepository.findByUser(user).stream().peek(Product::convertToDTO).collect(Collectors.toList());
    }
}
