package com.nikitadev.ecommercestore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikitadev.ecommercestore.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Product> getProducts() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Product> query = session.createQuery("from Product", Product.class);
		List<Product> products = query.getResultList();
		
		return products;
	}

	@Override
	public void saveProduct(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);
	}

	@Override
	public Product getProduct(int id) {
		Session session = entityManager.unwrap(Session.class);
		Product product = session.get(Product.class, id);
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<?> query = session.createQuery("delete from Product p where p.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}