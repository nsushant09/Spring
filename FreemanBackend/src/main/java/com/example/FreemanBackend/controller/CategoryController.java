package com.example.FreemanBackend.controller;

import com.example.FreemanBackend.model.Category;
import com.example.FreemanBackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Category> insertCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.insertCategory(category));
    }

    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }

    @GetMapping("/by_category_id")
    public ResponseEntity<Category> getCategoryById(@RequestParam("category_id") Integer categoryId){
        Category category = categoryService.getCategoryById(categoryId);

        if(category == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.ok(category);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
}
