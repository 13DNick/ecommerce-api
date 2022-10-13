package com.nikitadev.ecommercestore.dao;

import java.util.List;

import com.nikitadev.ecommercestore.entities.ProductCategory;

public interface ProductCategoryDAO {
	
	public List<ProductCategory> getProductCategories();
	
	public void saveProductCategory(ProductCategory productCategory);

	public ProductCategory getProductCategory(int id);

	public void deleteProductCategory(int id);
	
}
