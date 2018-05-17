package com.eshopbox.spring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eshopbox.spring.model.Department;
import com.eshopbox.spring.model.Employee;
import com.eshopbox.spring.model.Ticket;
import com.eshopbox.spring.model.TicketModel;
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
	
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public @ResponseBody String listDepartments() {
		List<Department> list=this.departmentService.listDepartments();
		
		ObjectMapper mapper = new ObjectMapper();
        try{
        	String jsonInString = mapper.writeValueAsString(list);
    		return jsonInString;
        }catch(Exception ex){
        	return "[]";
        }
		
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public @ResponseBody String listEmployee(@RequestParam String data) {
		try{
			List<Employee> list=null;
			if(data!=null ) {
				list=this.employeeService.getEmployeeByName(data);
			}else {
				list=this.employeeService.listEmployees();
			}
			ObjectMapper mapper = new ObjectMapper();
	        
	        	//List<Employee> filterList=
	        	String jsonInString = mapper.writeValueAsString(list);
	    		return jsonInString;
        }catch(Exception ex){
        	return "[]";
        }
		
		
	}
	
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public @ResponseBody String listTicket() {
		
		List<Ticket> list=this.ticketService.listTickets();
		ObjectMapper mapper = new ObjectMapper();
        try{
        	String jsonInString = mapper.writeValueAsString(list);
    		return jsonInString;
        }catch(Exception ex){
        	return "[]";
        }
		
		//return this.ticketService.listTickets().toString();
	}
	@RequestMapping(value = "/tickets/{managerid}", method = RequestMethod.GET)
	public @ResponseBody String listTicketByManagerId(@PathVariable Integer managerid) {
		
		List<Ticket> list=this.ticketService.getTicketByManagerId(managerid);
		ObjectMapper mapper = new ObjectMapper();
        try{
        	String jsonInString = mapper.writeValueAsString(list);
    		return jsonInString;
        }catch(Exception ex){
        	return "[]";
        }
		
		//return this.ticketService.listTickets().toString();
	}
	@RequestMapping(value = "/tickets/update/{ticketid}", method = RequestMethod.POST)
	public @ResponseBody String assignTicket(@PathVariable Integer ticketid,@RequestParam Integer userId) {
		try {
			ticketService.assignTicket(ticketid, userId);
			return "{\"status\":\"success\"} ";
		}catch(Exception ex){
			return "{\"status\":\"fail\"} ";
		}
				
		//return this.ticketService.listTickets().toString();
	}
	@RequestMapping(value = "/tickets/close/{ticketid}", method = RequestMethod.POST)
	public @ResponseBody String closeTicket(@PathVariable Integer ticketid,@RequestParam Integer userId) {
		try {
			ticketService.assignTicket(ticketid, userId);
			return "{\"status\":\"success\"} ";
		}catch(Exception ex){
			return "{\"status\":\"fail\"} ";
		}
				
		//return this.ticketService.listTickets().toString();
	}
	@RequestMapping(value = "/tickets/pending/{managerid}", method = RequestMethod.GET)
	public @ResponseBody String listPendingTicketByManagerId(@PathVariable Integer managerid) {
		
		List<Ticket> list=this.ticketService.getPendingTicketByManagerId(managerid);
		ObjectMapper mapper = new ObjectMapper();
        try{
        	String jsonInString = mapper.writeValueAsString(list);
    		return jsonInString;
        }catch(Exception ex){
        	return "[]";
        }
		
		//return this.ticketService.listTickets().toString();
	}
	
	@RequestMapping(value = "/tickets/pending/department/{departmentid}", method = RequestMethod.GET)
	public @ResponseBody String listPendingTicketByDepartmentId(@PathVariable Integer departmentid) {
		
		List<Ticket> list=this.departmentService.getPendingTicketByDepartment(departmentid);
		ObjectMapper mapper = new ObjectMapper();
        try{
        	String jsonInString = mapper.writeValueAsString(list);
    		return jsonInString;
        }catch(Exception ex){
        	return "[]";
        }
		
		//return this.ticketService.listTickets().toString();
	}
	
	
	
	/*@RequestMapping(value = "/ticket", method = RequestMethod.POST)
	public @ResponseBody String createTicket(@RequestBody Map<String,Object> ticketMap) {
		try {
			System.out.println(ticketMap.toString());
			Ticket ticket=new Ticket();
			ticket.setDescription(ticketMap.get("description").toString());
			ticket.setSummary(ticketMap.get("summary").toString());
			ticket.setCreatedBy(Integer.parseInt(ticketMap.get("createdBy").toString()));
			ticket.setCloseBy(Integer.parseInt(ticketMap.get("closeBy").toString()));
			ticket.setAssignedTo(Integer.parseInt(ticketMap.get("assignedTo").toString()));
			
		    this.ticketService.addTicket(ticket);
		
		return "fail";
		}catch(Exception ex) {
			//return "{\"  \"}";
			ex.printStackTrace();
			return "success";
		}
		
		//return this.ticketService.listTickets().toString();
	}*/
	
	@RequestMapping(value = "/ticket", method = RequestMethod.POST)
	public @ResponseBody String createTicket(@RequestBody Ticket ticket) {
		try {						
		    this.ticketService.addTicket(ticket);		
		return "{\"status\":\"success\"} ";
		}catch(Exception ex) {
			//return "{\"  \"}";
			ex.printStackTrace();
			return "{\"status\":\"fail\"} ";
		}
		
		//return this.ticketService.listTickets().toString();
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		return new ModelAndView("index");
	}
    

}
