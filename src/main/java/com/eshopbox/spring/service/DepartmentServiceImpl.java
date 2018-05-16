package com.eshopbox.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshopbox.spring.dao.DepartmentDAO;
import com.eshopbox.spring.model.Department;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;

	/*public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
*/
	@Override
	@Transactional
	public void addDepartment(Department p) {
		this.departmentDAO.addDepartment(p);
	}

	@Override
	@Transactional
	public void updateDepartment(Department p) {
		this.departmentDAO.updateDepartment(p);
	}

	@Override
	@Transactional
	public List<Department> listDepartments() {
		return this.departmentDAO.listDepartments();
	}

	@Override
	@Transactional
	public Department getDepartmentById(int id) {
		return this.departmentDAO.getDepartmentById(id);
	}

	@Override
	@Transactional
	public void removeDepartment(int id) {
		this.departmentDAO.removeDepartment(id);
	}

}
