package com.nikitadev.ecommercestore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikitadev.ecommercestore.entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customer = query.getResultList();
		
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<?> query = session.createQuery("delete from Customer c where c.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
