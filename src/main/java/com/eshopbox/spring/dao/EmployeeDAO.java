package com.eshopbox.spring.dao;

import java.util.List;

import com.eshopbox.spring.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee p);
	public void updateEmployee(Employee p);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
}
