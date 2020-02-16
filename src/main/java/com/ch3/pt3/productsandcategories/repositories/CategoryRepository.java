package com.ch3.pt3.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ch3.pt3.productsandcategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
    // this method retrieves all the objects from the database
    List<Category> findAll();
    // this method retrieves an object by its id
    Optional<Category> findById(Long id);
    
}

