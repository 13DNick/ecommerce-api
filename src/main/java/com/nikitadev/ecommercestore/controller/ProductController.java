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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikitadev.ecommercestore.entities.Product;
import com.nikitadev.ecommercestore.error.ProductNotFoundException;
import com.nikitadev.ecommercestore.service.ProductService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/products/search")
	@ApiOperation(value="Search all products by keyword")
	public List<Product> searchProduct(@RequestParam("q") String query){
		List<Product> results = this.productService.searchProduct(query);
		
		
		return results;
	}
	
	
	@GetMapping("/products")
	@ApiOperation(value="Get all products")
	public List<Product> getProducts(){
		return this.productService.getProducts();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value="Get a product by id")
	public Product getProduct(@PathVariable int id) {
		Product product = this.productService.getProduct(id);
		
		if(product == null) {
			throw new ProductNotFoundException("Product id not found: " + id);
		}
		
		return product;
	}
	
	@PostMapping("/product")
	@ApiOperation(value="Save a product", notes="MUST provide a valid/existing productCategory Id")
	public void saveProduct(@RequestBody Product product) {
		//ignore any id sent in the request – overwrite id with 0
		product.setId(0);
		this.productService.saveProduct(product);
	}
	
	@PutMapping("/product")
	@ApiOperation(value="Update a product", notes="MUST provide an existing product id AND productCategory id.")
	public Product updateProduct(@RequestBody Product product) {
		this.productService.saveProduct(product);
		return product;
	}
	
	@DeleteMapping("/product/{id}")
	@ApiOperation(value="Delete a product")
	public void deleteProduct(@PathVariable int id) {
		Product product = this.productService.getProduct(id);
		
		if(product == null) {
			throw new ProductNotFoundException("Product id not found: " + id);
		}
		
		this.productService.deleteProduct(id);
	}
	
}
