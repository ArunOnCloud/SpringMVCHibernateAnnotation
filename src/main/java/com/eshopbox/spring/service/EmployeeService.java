package com.eshopbox.spring.service;

import java.util.List;

import com.eshopbox.spring.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee p);
	public void updateEmployee(Employee p);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
	public List<Employee> getEmployeeByName(String name);
	
}
