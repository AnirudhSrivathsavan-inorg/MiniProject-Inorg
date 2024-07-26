package com.inorg.miniproject.controller;

import com.inorg.miniproject.model.Category;
import com.inorg.miniproject.model.Customer;
import com.inorg.miniproject.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {
    CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("categories/{categoryId}")
    public String getCategoriesbyId(@PathVariable Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            return "Category does not exist";
        }
        return category.toString();
    }

    @PostMapping("categories")
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("categories/{categoryId}")
    public String updateCatagorybyId(@PathVariable Integer categoryId, @RequestBody Category updatedCategory) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            return "Category does not exist";
        }
        category.setCategory_name(updatedCategory.getCategory_name());
        return "Category name updated!";
    }

    @DeleteMapping("categories/{categoryId}")
    public String deleteCategorysbyId(@PathVariable Integer categoryId) {
        categoryRepository.deleteById(categoryId);
        return "Deleted Category";
    }
}
