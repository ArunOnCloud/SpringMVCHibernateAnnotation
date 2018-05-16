package com.eshopbox.spring.service;

import java.util.List;

import com.eshopbox.spring.model.Department;

public interface DepartmentService {

	public void addDepartment(Department p);
	public void updateDepartment(Department p);
	public List<Department> listDepartments();
	public Department getDepartmentById(int id);
	public void removeDepartment(int id);
	
}
