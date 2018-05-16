package com.eshopbox.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshopbox.spring.model.Person;
import com.eshopbox.spring.service.DepartmentService;
import com.eshopbox.spring.service.EmployeeService;
import com.eshopbox.spring.service.PersonService;

@Controller
public class TestController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	/*@Autowired(required=true)
	@Qualifier(value="departmentService")
	public void setDepartmentService(DepartmentService ps){
		this.departmentService = ps;
	}*/
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public @ResponseBody String listPersons(Model model) {
		/*model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.departmentService.listDepartments());*/
		return this.departmentService.listDepartments().toString();
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public @ResponseBody String listEmployee(Model model) {
		/*model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.departmentService.listDepartments());*/
		return this.employeeService.listEmployees().toString();
	}
    

}
