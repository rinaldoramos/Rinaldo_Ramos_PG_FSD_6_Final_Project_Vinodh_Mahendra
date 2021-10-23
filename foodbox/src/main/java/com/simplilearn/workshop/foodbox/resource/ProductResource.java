package com.simplilearn.workshop.foodbox.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.foodbox.model.Products;
import com.simplilearn.workshop.foodbox.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	private final ProductService productService;
	
	public ProductResource (ProductService productService) {
		this.productService = productService;
	}
	
	// Get all data
	@GetMapping("/all")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> list = productService.getAllProducts();
		
		if (!(list.isEmpty())) {
			return new ResponseEntity<>(list, HttpStatus.OK);		
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	// Get product by ID
	@GetMapping("/find/{id}")
	public ResponseEntity<Products> findProductById(@PathVariable("id") Long id){
		Products product = productService.getProductById(id);
		
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}else {
			return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Add a product
	@PostMapping("/add")
	public ResponseEntity<Products> addProduct(@RequestBody Products product){
		Products item = productService.addProduct(product);
		
		if (item != null) {
			return new ResponseEntity<>(item, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
		}
	}
	
	// Update a product
	@PutMapping("/update")
	public ResponseEntity<Products> updateProduct(@RequestBody Products product){
		Products item = productService.updateProduct(product);
		
		if (item != null) {
			return new ResponseEntity<>(item, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
		}
	}
	
	// Delete a product
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Products> deleteProductById(@PathVariable("id") Long id){
		productService.deleteProductById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
