package com.simplilearn.workshop.foodbox.exception;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
