package com.nikitadev.ecommercestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikitadev.ecommercestore.dao.ProductCategoryDAO;
import com.nikitadev.ecommercestore.entities.ProductCategory;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	private ProductCategoryDAO productCategoryDAO;
	
	@Override
	public List<ProductCategory> getProductCategories() {
		return this.productCategoryDAO.getProductCategories();
	}

	@Override
	public void saveProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductCategory getProductCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductCategory(int id) {
		// TODO Auto-generated method stub
		
	}

}
