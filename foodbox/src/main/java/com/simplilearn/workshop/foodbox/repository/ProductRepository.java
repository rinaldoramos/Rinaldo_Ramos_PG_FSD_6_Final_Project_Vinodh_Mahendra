package com.simplilearn.workshop.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.foodbox.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

	
}
