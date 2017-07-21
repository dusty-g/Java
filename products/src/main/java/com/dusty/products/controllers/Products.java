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
@RequestMapping("/products")
public class Products {
    ProductService productService;
    CategoryService categoryService;
    public Products(ProductService productService, CategoryService categoryService){
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @RequestMapping("/new")
    public String newProductPage(@ModelAttribute("product") Product product){
        return "/WEB-INF/views/newProduct.jsp";
    }
    @PostMapping("/new")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/newProduct.jsp";
        }else{
            productService.saveProduct(product);
            return "redirect:/products/"+product.getId();
        }
    }
    @RequestMapping("/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model){
        //get product
        //get categories by product
        Product product = productService.getById(id);
        Iterable<Category> categories = categoryService.availableCategoriesForProduct(product);
        System.out.println(categories);
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "/WEB-INF/views/product.jsp";
    }
    @PostMapping("/addcategory")
    public String addCategory(@RequestParam("categoryVal") Long id, @RequestParam("productId") Long productId, Model model){
        Category category = categoryService.getById(id);
        Product product = productService.getById(productId);
        List<Category> categories = product.getCategories();
        categories.add(category);
        product.setCategories(categories);
        productService.saveProduct(product);
        return "redirect:/products/"+product.getId();
    }
}
