package com.ch3.pt3.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ch3.pt3.productsandcategories.models.Category;
import com.ch3.pt3.productsandcategories.models.CategoryProduct;
import com.ch3.pt3.productsandcategories.models.Product;
import com.ch3.pt3.productsandcategories.services.CategoryProductService;
import com.ch3.pt3.productsandcategories.services.CategoryService;
import com.ch3.pt3.productsandcategories.services.ProductService;

@Controller
public class MainController {
 
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CategoryProductService categoryProductService;
 
    public MainController(
    		ProductService productService,
    		CategoryService categoryService,
    		CategoryProductService categoryProductService
    		) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.categoryProductService = categoryProductService;
    }
 
    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product){
        return "newProduct.jsp";
    }
 
    @PostMapping("/products/create")
    public String createProduct(
        @Valid @ModelAttribute("product") Product product,
        BindingResult result){
        if (result.hasErrors()){
            return "newProduct.jsp";
        }
        productService.createProduct(product);
        return "redirect:/products/new";
    }
    
    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category){
        return "newCategory.jsp";
    }
 
    @PostMapping("/categories/create")
    public String createCategory(
        @Valid @ModelAttribute("category") Category category,
        BindingResult result){
        if (result.hasErrors()){
            return "newCategory.jsp";
        }
        categoryService.createCategory(category);
        return "redirect:/categories/new";
    }

    @GetMapping("products/{id}")
    public String detailProduct(
    		@PathVariable("id") Long id,
    		Model model,
    		@ModelAttribute("category") Category category
    		){
    	Product currentProduct = productService.getProduct(id);
    	List<Category> currentProductCategory = currentProduct.getCategories();
    	System.out.println(currentProductCategory);
    	List<Category> categories = categoryService.allCategories();
    	for (Category c : currentProductCategory) {
    		categories.remove(c);    		
    	}
    	System.out.println(categories);
        model.addAttribute("currentProduct", currentProduct);
        model.addAttribute("categories", categories);
        return "detailProduct.jsp";
    }

    @PostMapping("products/addcategory/{id}")
    public String addCategory(
    		@ModelAttribute("categoryProduct") Category category,
    		@PathVariable("id") Long productId
    		){
    	System.out.println(category);
    	CategoryProduct cp = new CategoryProduct();
    	Product product = productService.getProduct(productId);
    	cp.setProduct(product);
    	cp.setCategory(category);
    	categoryProductService.createRelationship(cp);
    	return "redirect:/products/new";
    }

    @GetMapping("categories/{id}")
    public String detailCategory(
    		@PathVariable("id") Long id,
    		Model model,
    		@ModelAttribute("product") Product product
    		){
    	Category currentCategory = categoryService.getCategory(id);
    	List<Product> currentCategoryProduct = currentCategory.getProducts();
    	System.out.println(currentCategoryProduct);
    	List<Product> products = productService.allProducts();
    	for (Product p : currentCategoryProduct) {
    		products.remove(p);    		
    	}
    	System.out.println(products);
        model.addAttribute("currentCategory", currentCategory);
        model.addAttribute("products", products);
        return "detailCategory.jsp";
    }

    @PostMapping("categories/addproduct/{id}")
    public String addProduct(
    		@ModelAttribute("categoryProduct") Product product,
    		@PathVariable("id") Long categoryId
    		){
    	CategoryProduct cp = new CategoryProduct();
    	Category category = categoryService.getCategory(categoryId);
    	cp.setCategory(category);
    	cp.setProduct(product);
    	categoryProductService.createRelationship(cp);
    	return "redirect:/categories/new";
    }
 
}
