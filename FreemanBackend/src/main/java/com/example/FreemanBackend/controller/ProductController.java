package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.model.Category;
import com.example.FreemanBackend.model.Product;
import com.example.FreemanBackend.model.User;
import com.example.FreemanBackend.service.CategoryService;
import com.example.FreemanBackend.service.ProductService;
import com.example.FreemanBackend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Product> insertProduct(@RequestParam("user_id") String userId, @RequestParam("category_id") String categoryId, @RequestBody Product product) {
        product.category = categoryService.getCategoryById(Integer.parseInt(categoryId));
        product.user = userService.getUserById(Integer.parseInt(userId));
        Product responseProduct = productService.insertProduct(product);
        return ResponseEntity.ok(responseProduct);
    }

    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product responseProduct = productService.insertProduct(product);
        return ResponseEntity.ok(responseProduct);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by_product_id")
    public ResponseEntity<Product> getProductById(@RequestParam("product_id") Integer productId) {
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/by_category_id")
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam("category_id") Integer categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        List<Product> products = productService.getProductByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by_user_id")
    public ResponseEntity<List<Product>> getProductByUser(@RequestParam("user_id") Integer userId) {
        User user = userService.getUserById(userId);
        List<Product> products = productService.getProductByUser(user);
        return ResponseEntity.ok(products);
    }

}
