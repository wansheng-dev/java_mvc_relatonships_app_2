package com.ch3.pt3.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ch3.pt3.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    // this method retrieves all the objects from the database
    List<Product> findAll();
    // this method retrieves an object by its id
    Optional<Product> findById(Long id);
}
