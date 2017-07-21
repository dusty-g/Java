package com.dusty.products.repositories;

import com.dusty.products.models.Category;
import com.dusty.products.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dusty on 7/21/17.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findAllByCategoriesEquals(Category category);
    List<Product> findByCategoriesNotContains(Category category);
}
