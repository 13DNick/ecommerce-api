package com.nikitadev.ecommercestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikitadev.ecommercestore.entities.Employee;
import com.nikitadev.ecommercestore.entities.ProductCategory;
import com.nikitadev.ecommercestore.service.EmployeeService;
import com.nikitadev.ecommercestore.service.ProductCategoryService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RESTController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return this.employeeService.getEmployees();
	}
	
	@GetMapping("/product_categories")
	public List<ProductCategory> getProductCategories(){
		return this.productCategoryService.getProductCategories();
	}
	
}
