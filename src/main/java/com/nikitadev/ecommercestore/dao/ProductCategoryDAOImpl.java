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
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(productCategory);	
	}

	@Override
	public ProductCategory getProductCategory(int id) {
		Session session = entityManager.unwrap(Session.class);
		ProductCategory productCategory = session.get(ProductCategory.class, id);
		return productCategory;
	}

	@Override
	public void deleteProductCategory(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<?> query = session.createQuery("delete from ProductCategory c where c.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
