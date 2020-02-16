package com.ch3.pt3.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ch3.pt3.productsandcategories.models.Product;
import com.ch3.pt3.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
 
    private final ProductRepository productRepo;
 
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
 
    public List<Product> allProducts(){
        return productRepo.findAll();
    }
 
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
 
    public Product getProduct(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return null;
    }
 
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }
 
    public void deleteProduct(Long id) {
    	productRepo.deleteById(id);
    }
  
}
