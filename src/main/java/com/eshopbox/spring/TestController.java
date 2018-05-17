package com.eshopbox.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eshopbox.spring.model.Employee;
import com.eshopbox.spring.service.DepartmentService;
import com.eshopbox.spring.service.EmployeeService;
import com.eshopbox.spring.service.TicketService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class TestController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private TicketService ticketService;
	
	
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public @ResponseBody String listPersons(Model model) {
		
		return this.departmentService.listDepartments().toString();
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public @ResponseBody String listEmployee(Model model) {
		
		List<Employee> list=this.employeeService.listEmployees();
		ObjectMapper mapper = new ObjectMapper();
        try{
        	String jsonInString = mapper.writeValueAsString(list);
    		return jsonInString;
        }catch(Exception ex){
        	return "[]";
        }
		
		
	}
	
	@RequestMapping(value = "/ticket", method = RequestMethod.GET)
	public @ResponseBody String listTicket(Model model) {
		
		return this.ticketService.listTickets().toString();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		return new ModelAndView("index");
	}
    

}
