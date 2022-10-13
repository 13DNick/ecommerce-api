package com.nikitadev.ecommercestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikitadev.ecommercestore.dao.ProductCategoryDAO;
import com.nikitadev.ecommercestore.entities.ProductCategory;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	private ProductCategoryDAO productCategoryDAO;
	
	@Override
	@Transactional
	public List<ProductCategory> getProductCategories() {
		return this.productCategoryDAO.getProductCategories();
	}

	@Override
	@Transactional
	public void saveProductCategory(ProductCategory productCategory) {
		this.productCategoryDAO.saveProductCategory(productCategory);
	}

	@Override
	@Transactional
	public ProductCategory getProductCategory(int id) {
		return this.productCategoryDAO.getProductCategory(id);
	}

	@Override
	@Transactional
	public void deleteProductCategory(int id) {
		this.productCategoryDAO.deleteProductCategory(id);
	}

}
