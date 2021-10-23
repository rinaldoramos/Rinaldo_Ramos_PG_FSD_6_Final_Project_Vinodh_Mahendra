package com.simplilearn.workshop.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.foodbox.exception.ProductNotFoundException;
import com.simplilearn.workshop.foodbox.model.Products;
import com.simplilearn.workshop.foodbox.repository.ProductRepository;

@Service
public class ProductService {

	public final ProductRepository productRepository;
	
	// Constructor
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	// Get all products
	public List<Products> getAllProducts(){
		return productRepository.findAll();
	}
	
	// Get product by ID
	public Products getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("The product with ID: " + id + " was not found"));
	}
	
	// Insert a Product
	public Products addProduct(Products product) {
		return productRepository.save(product);
	}
	
	// Update a product
	public Products updateProduct(Products product) {
		if (productRepository.findById(product.getId()) != null) {
			return productRepository.save(product);
		}else {
			return product;
		}
	}
	
	// Delete a product
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
}
