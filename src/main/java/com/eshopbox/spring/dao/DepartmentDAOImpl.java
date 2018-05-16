package com.eshopbox.spring.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshopbox.spring.model.Department;

@Repository("departmentDAO")
public class DepartmentDAOImpl implements DepartmentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public void addDepartment(Department p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Department saved successfully, Department Details="+p);
	}

	@Override
	public void updateDepartment(Department p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Department updated successfully, Department Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> listDepartments() {
		Session session = this.sessionFactory.getCurrentSession();
		//Session session = this.sessionFactory.openSession();
		try{
			List<Department> departmentsList = session.createQuery("from Department").list();
			for(Department p : departmentsList){
				logger.info("Department List::"+p);
			}
			return departmentsList;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return new LinkedList<Department>();
	}

	@Override
	public Department getDepartmentById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Department p = (Department) session.load(Department.class, new Integer(id));
		logger.info("Department loaded successfully, Department details="+p);
		return p;
	}

	@Override
	public void removeDepartment(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Department p = (Department) session.load(Department.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Department deleted successfully, department details="+p);
	}

}
