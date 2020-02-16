package com.ch3.pt3.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ch3.pt3.productsandcategories.models.Category;
import com.ch3.pt3.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
 
    private final CategoryRepository categoryRepo;
 
    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
 
    public List<Category> allCategories(){
        return categoryRepo.findAll();
    }
 
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
 
    public Category getCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        return null;
    }
 
    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }
 
    public void deleteCategory(Long id) {
    	categoryRepo.deleteById(id);
    }
  
}
