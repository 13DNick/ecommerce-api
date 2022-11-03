package com.nikitadev.ecommercestore.aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.nikitadev.ecommercestore.deserializer.ProductDeserializer;
import com.nikitadev.ecommercestore.entities.Product;
import com.nikitadev.ecommercestore.entities.ProductCategory;
import com.nikitadev.ecommercestore.service.ProductCategoryService;

@Component
public class StartupRunner implements CommandLineRunner{
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	private static final Logger LOGGER =
		      Logger.getLogger(StartupRunner.class.getName());
	
	@Override
	public void run(String... args) throws Exception {
		
		//check if database records are empty
		//empty - populate via api request
		//not empty - do nothing
		
		if(productCategoryService.getProductCategories().size() == 0) {
			LOGGER.info("categories table is empty");
			
			//request all categories and convert to pojo
			List<ProductCategory> categories = this.jsonToProductCategory(this.getCategories());
			LOGGER.info("CATEGORIES: " + categories.toString());
			
			LOGGER.info("===================");
			
			List<Product> products = this.jsonToProduct(this.getProducts());
			LOGGER.info("PRODUCTS: " + products.toString());
			
			LOGGER.info("===================");
			LOGGER.info("CATEGORIZING ======================");
			this.categorize(categories, products);
			LOGGER.info("POPULATING DATABASE ======================");
			this.populateDatabase(categories);
			
		} else {
			LOGGER.info("categories record amount: " + productCategoryService.getProductCategories().size());
		}
		
	}
	
	public void populateDatabase(List<ProductCategory> categories) {
		for(ProductCategory category: categories) {
			this.productCategoryService.saveProductCategory(category);
		}
	}
	
	public void categorize(List<ProductCategory> categories, List<Product> products) {
		for(ProductCategory category: categories) {
			for(Product product: products) {
				if(product.getCategory().equals(category.getName())) {
					category.addProduct(product);
				}
			}
		}
	}
	
	
	public List<Object> getProducts(){
		String url = "https://fakestoreapi.com/products";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] products = restTemplate.getForObject(url, Object[].class);
		
		return Arrays.asList(products);
	}
	
	public List<Product> jsonToProduct(List<Object> list) throws JsonMappingException, JsonProcessingException{
		List<Product> products = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		
		//register custom deserializer
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Product.class, new ProductDeserializer());
		mapper.registerModule(module);
		
		for(Object product: list) {
			//serialize back to json string
			String temp = mapper.writeValueAsString(product);
			
			//deserialize via custum deserializer
			Product p = mapper.readValue(temp, Product.class);
			products.add(p);
		}
		
		return products;
	}
	
	
	public List<Object> getCategories(){
		String url = "https://fakestoreapi.com/products/categories";
		
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] categories = restTemplate.getForObject(url, Object[].class);
		
		return Arrays.asList(categories);
	}
	
	public List<ProductCategory> jsonToProductCategory(List<Object> list){
		List<ProductCategory> categories = new ArrayList<>();
		
		for(Object category: list) {
			categories.add(new ProductCategory(category.toString()));
		}
		
		return categories;
	}

}
