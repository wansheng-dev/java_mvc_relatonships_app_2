package com.ch3.pt3.productsandcategories.services;

import org.springframework.stereotype.Service;

import com.ch3.pt3.productsandcategories.models.CategoryProduct;
import com.ch3.pt3.productsandcategories.repositories.CategoryProductReposiotry;

@Service
public class CategoryProductService {

	 private final CategoryProductReposiotry categoryProductRepo;
	 
	 public CategoryProductService(CategoryProductReposiotry categoryProductRepo) {
		 this.categoryProductRepo = categoryProductRepo;
	 }
	 
	 public CategoryProduct createRelationship(CategoryProduct cp) {
		 return this.categoryProductRepo.save(cp);
	 }
	 
}
