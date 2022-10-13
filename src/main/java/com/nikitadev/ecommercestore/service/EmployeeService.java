package com.nikitadev.ecommercestore.service;

import java.util.List;

import com.nikitadev.ecommercestore.entities.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public void saveEmployee(Employee customer);

	public Employee getEmployee(int id);

	public void deleteEmployee(int id);
	
}
