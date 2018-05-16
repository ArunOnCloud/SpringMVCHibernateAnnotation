package com.eshopbox.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author arun
 *
 */
@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="departmentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departmentId;
	
	
	
	private String departmentName;


	


	

	public int getDepartmentId() {
		return departmentId;
	}







	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}







	public String getDepartmentName() {
		return departmentName;
	}







	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}







	@Override
	public String toString() {
		return "Department [department_id=" + departmentId
				+ ", departmentName=" + departmentName + "]";
	}
	
	

	
	
}
