package com.dusty.products.services;

import com.dusty.products.models.Category;
import com.dusty.products.models.Product;
import com.dusty.products.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

/**
 * Created by dusty on 7/21/17.
 */
@Service
public class CategoryService {
    CategoryRepository categoryRepo;
    public CategoryService(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }
    public void saveCategory(Category category){
        categoryRepo.save(category);
    }
    public Category getById(Long id){
        return categoryRepo.findOne(id);
    }
    public Iterable<Category> availableCategoriesForProduct(Product product){
        return categoryRepo.findByProductsNotContains(product);
    }
}
