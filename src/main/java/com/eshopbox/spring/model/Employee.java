package com.eshopbox.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="employeeId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	
	@Column(name="employeeName")
    private String employeeName;
	
	@Column(name="managerEmployeeId")
	private int managerEmployeeId;
	
	/*@Column(name="departmentId")
	private int departmentId;*/
	
	/*@ManyToOne
	@JoinColumn(name="cart_id", nullable=false)
	private Cart1 cart1;*/
	
	@ManyToOne
	@JoinColumn(name="departmentId", nullable=false)
	private Department department;
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getManagerEmployeeId() {
		return managerEmployeeId;
	}

	public void setManagerEmployeeId(int managerEmployeeId) {
		this.managerEmployeeId = managerEmployeeId;
	}

	/*public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}*/

	/*@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", managerEmployeeId=" + managerEmployeeId
				+ ", departmentId=" + departmentId +" ,department="+ department+ "]";
	}*/
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", managerEmployeeId=" + managerEmployeeId
				+ ", departmentId=" + " "+" ,department="+ department+ "]";
	}

	

}
