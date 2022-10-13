package com.nikitadev.ecommercestore.service;

import java.util.List;

import com.nikitadev.ecommercestore.entities.ProductCategory;

public interface ProductCategoryService {
	
	public List<ProductCategory> getProductCategories();
	
	public void saveProductCategory(ProductCategory productCategory);

	public ProductCategory getProductCategory(int id);

	public void deleteProductCategory(int id);
	
}
