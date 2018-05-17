package com.eshopbox.spring.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshopbox.spring.dao.DepartmentDAO;
import com.eshopbox.spring.model.Department;
import com.eshopbox.spring.model.Employee;
import com.eshopbox.spring.model.Ticket;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	EmployeeService employeeService;
	
	

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
	
	@Override
	@Transactional
	public List<Ticket> getPendingTicketByDepartment(int departmentId) {
		Department department=this.getDepartmentById(departmentId);
		List<Employee> listEmployee=employeeService.listEmployees();
		Set<Integer> set=new TreeSet<Integer>();
		for(Employee employee:listEmployee) {
			if(departmentId == employee.getDepartment().getDepartmentId()) {
				set.add(employee.getEmployeeId());
			}
		}
		List<Ticket> result=new LinkedList<Ticket>();
		for(Integer managerId: set) {
			List<Ticket> pendingTickets=ticketService.getPendingTicketByManagerId(managerId);
			result.addAll(pendingTickets);
		}
		
		return result;
		
	}

}
