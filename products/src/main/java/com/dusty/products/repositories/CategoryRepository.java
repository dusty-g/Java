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
public interface CategoryRepository extends CrudRepository<Category, Long>{
    //untested
    List<Category> findAllByProductsNot(Product product);
    List<Category> findByProducts(Product product);
    List<Category> findByProductsNot(Product product);
    List<Category> findByProductsNotContains(Product product);
}
