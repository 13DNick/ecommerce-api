package com.nikitadev.ecommercestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nikitadev.ecommercestore.dao.ProductDAO;
import com.nikitadev.ecommercestore.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return this.productDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		this.productDAO.saveProduct(product);	
	}

	@Override
	@Transactional
	public Product getProduct(int id) {
		return this.productDAO.getProduct(id);
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		this.productDAO.deleteProduct(id);
	}

}
