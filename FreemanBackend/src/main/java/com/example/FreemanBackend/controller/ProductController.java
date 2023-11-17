package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.dto_model.ProductDTO;
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
import java.util.Set;

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
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by_product_id")
    public ResponseEntity<ProductDTO> getProductById(@RequestParam("product_id") Integer productId) {
        ProductDTO product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/by_category_id")
    public ResponseEntity<List<ProductDTO>> getProductByCategory(@RequestParam("category_id") Integer categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        List<ProductDTO> products = productService.getProductByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/by_user_id")
    public ResponseEntity<List<ProductDTO>> getProductByUser(@RequestParam("user_id") Integer userId) {
        User user = userService.getUserById(userId);
        List<ProductDTO> products = productService.getProductByUser(user);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<Set<Product>> getProductBySearchValue(@RequestParam("value") String value) {
        Set<Product> products = productService.getProductBySearchValue(value);
        return ResponseEntity.ok(products);
    }

}
