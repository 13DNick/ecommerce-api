package com.nikitadev.ecommercestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikitadev.ecommercestore.dao.EmployeeDAO;
import com.nikitadev.ecommercestore.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> getEmployees() {
		return this.employeeDAO.getEmployees();
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
