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

import com.nikitadev.ecommercestore.entities.ProductCategory;
import com.nikitadev.ecommercestore.error.ProductCategoryNotFoundException;
import com.nikitadev.ecommercestore.service.ProductCategoryService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	
	@GetMapping("/categories")
	@ApiOperation(value="Get all categories")
	public List<ProductCategory> getProductCategories(){
		return this.productCategoryService.getProductCategories();
	}
	
	@GetMapping("/category/{id}")
	@ApiOperation(value="Get a category by id")
	private ProductCategory getProductCategory(@PathVariable int id) {
		ProductCategory category = this.productCategoryService.getProductCategory(id);
		
		if(category == null) {
			throw new ProductCategoryNotFoundException("Category id not found: " + id);
		}
		
		return category;
	}
	
	@PutMapping("/category")
	@ApiOperation(value="Update a category", notes="MUST provide an existing category id.")
	public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {
		this.productCategoryService.saveProductCategory(productCategory);
		return productCategory;
	}
	
	@PostMapping("/category")
	@ApiOperation(value="Save a category", notes="you can provide any ID, it will be autogenerated.")
	public void saveProductCategory(@RequestBody ProductCategory productCategory) {
		//ignore any id sent in the request ??? overwrite id with 0
		productCategory.setId(0);
		this.productCategoryService.saveProductCategory(productCategory);
	}
	
	@DeleteMapping("/category/{id}")
	@ApiOperation(value="Delete a category", notes="Category must be empty to delete.")
	public void deleteProductCategory(@PathVariable int id) {
		ProductCategory productCategory = this.productCategoryService.getProductCategory(id);
		if(productCategory == null) {
			throw new ProductCategoryNotFoundException("Category id not found: " + id);
		}
		this.productCategoryService.deleteProductCategory(id);
	}
	
}
