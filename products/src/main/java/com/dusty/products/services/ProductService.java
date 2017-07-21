package com.dusty.products.services;

import com.dusty.products.models.Category;
import com.dusty.products.models.Product;
import com.dusty.products.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dusty on 7/21/17.
 */
@Service
public class ProductService {
    ProductRepository productRepo;
    public ProductService(ProductRepository productRepo){
        this.productRepo = productRepo;
    }
    public void saveProduct(Product product){
        productRepo.save(product);
    }
    public List<Product> getByCategory(Category category){
        return productRepo.findAllByCategoriesEquals(category);
    }
    public Product getById(Long id){
        return productRepo.findOne(id);
    }
    public Iterable<Product> availableProductsForCategory(Category category){
        return productRepo.findByCategoriesNotContains(category);
    }
}
