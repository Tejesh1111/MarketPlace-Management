package com.example.Backend.service;

import com.example.Backend.entity.Category;
import com.example.Backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // MANUAL CONSTRUCTOR (important)
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}