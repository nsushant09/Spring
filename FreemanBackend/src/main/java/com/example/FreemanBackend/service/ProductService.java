package com.example.FreemanBackend.service;

import com.example.FreemanBackend.dto_model.Mapper;
import com.example.FreemanBackend.dto_model.ProductDTO;
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
import java.util.Set;
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

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(Mapper::toDto).collect(Collectors.toList());
    }

    public ProductDTO getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(Mapper::toDto).orElse(null);
    }

    public Product getOrignalProductById(Integer id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public List<ProductDTO> getProductByCategory(Category category) {
        return productRepository.findByCategory(category).stream().map(Mapper::toDto).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByUser(User user) {
        return productRepository.findByUser(user).stream().map(Mapper::toDto).collect(Collectors.toList());
    }

    public Set<Product> getProductBySearchValue(String value) {
        return productRepository.findByProductNameOrCategoryName(value);
    }
}
