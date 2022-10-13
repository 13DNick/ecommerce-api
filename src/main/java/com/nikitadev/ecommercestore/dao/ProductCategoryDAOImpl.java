package com.nikitadev.ecommercestore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikitadev.ecommercestore.entities.ProductCategory;

@Repository
public class ProductCategoryDAOImpl implements ProductCategoryDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<ProductCategory> getProductCategories() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<ProductCategory> query = session.createQuery("from ProductCategory", ProductCategory.class);
		List<ProductCategory> productCategories = query.getResultList();
		
		return productCategories;
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
