package com.dusty.products.controllers;

import com.dusty.products.models.Category;
import com.dusty.products.models.Product;
import com.dusty.products.repositories.CategoryRepository;
import com.dusty.products.repositories.ProductRepository;
import com.dusty.products.services.CategoryService;
import com.dusty.products.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by dusty on 7/21/17.
 */
@Controller
@RequestMapping("/categories")
public class Categories {
    CategoryService categoryService;
    ProductService productService;
    public Categories(CategoryService categoryService, ProductService productService){
        this.categoryService = categoryService;
        this.productService = productService;
    }
    @RequestMapping("/new")
    public String newCategoryPage(@ModelAttribute Category category){
        return "/WEB-INF/views/newCategory.jsp";
    }
    @PostMapping("/new")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/newCategory.jsp";
        }else{
            categoryService.saveCategory(category);
            return "redirect:/categories/"+category.getId();
        }
    }
    @RequestMapping("/{id}")
    public String getCategory(@PathVariable("id") Long id, Model model){
        //get category by id
        Category category = categoryService.getById(id);
        //find products by category
        //add to model

//        model.addAttribute("products", products);
        Iterable<Product> products = productService.availableProductsForCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "/WEB-INF/views/category.jsp";

    }
    @PostMapping("/addproduct")
    public String addProduct(@RequestParam("categoryId") Long catId, @RequestParam("productVal") Long productId){
        Product product = productService.getById(productId);
        Category category = categoryService.getById(catId);
        List<Product> products = category.getProducts();
        products.add(product);
        category.setProducts(products);
        categoryService.saveCategory(category);
        return "redirect:/categories/"+category.getId();
    }
}
