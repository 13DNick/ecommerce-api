package com.nikitadev.ecommercestore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikitadev.ecommercestore.entities.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> getEmployees() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("from Employee order by lastName", Employee.class);
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public void saveEmployee(Employee customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

}
