package com.nikitadev.ecommercestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikitadev.ecommercestore.entities.Product;
import com.nikitadev.ecommercestore.error.ProductNotFoundException;
import com.nikitadev.ecommercestore.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return this.productService.getProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {
		Product product = this.productService.getProduct(id);
		
		if(product == null) {
			throw new ProductNotFoundException("Product id not found: " + id);
		}
		
		return product;
	}
	
	@PostMapping("/product")
	public void saveProduct(@RequestBody Product product) {
		//ignore any id sent in the request – overwrite id with 0
		product.setId(0);
		this.productService.saveProduct(product);
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		this.productService.saveProduct(product);
		return product;
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable int id) {
		Product product = this.productService.getProduct(id);
		
		if(product == null) {
			throw new ProductNotFoundException("Product id not found: " + id);
		}
		
		this.productService.deleteProduct(id);
	}
	
}
