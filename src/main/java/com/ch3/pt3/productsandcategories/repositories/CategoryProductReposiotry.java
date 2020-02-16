package com.ch3.pt3.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ch3.pt3.productsandcategories.models.CategoryProduct;

@Repository
public interface CategoryProductReposiotry extends CrudRepository<CategoryProduct, Long>{
	List<CategoryProduct> findAll();
}
