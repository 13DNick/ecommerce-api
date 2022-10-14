package com.nikitadev.ecommercestore.dao;

import java.util.List;

import com.nikitadev.ecommercestore.entities.Product;

public interface ProductDAO {
	
	public List<Product> getProducts();
	
	public void saveProduct(Product product);

	public Product getProduct(int id);

	public void deleteProduct(int id);
	
}
