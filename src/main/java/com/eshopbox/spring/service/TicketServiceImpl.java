package com.eshopbox.spring.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshopbox.spring.dao.TicketDAO;
import com.eshopbox.spring.model.Ticket;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDAO ticketDAO;

	/*public void setTicketDAO(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}
*/
	@Override
	@Transactional
	public void addTicket(Ticket p) {
		this.ticketDAO.addTicket(p);
	}

	@Override
	@Transactional
	public void updateTicket(Ticket p) {
		this.ticketDAO.updateTicket(p);
	}

	@Override
	@Transactional
	public List<Ticket> listTickets() {
		return this.ticketDAO.listTickets();
	}

	@Override
	@Transactional
	public Ticket getTicketById(int id) {
		return this.ticketDAO.getTicketById(id);
	}

	@Override
	@Transactional
	public void removeTicket(int id) {
		this.ticketDAO.removeTicket(id);
	}
	@Override
	@Transactional
	public List<Ticket> getTicketByManagerId(Integer managerId){
		return this.ticketDAO.getTicketByManagerId(managerId);
	}
	@Override
	@Transactional
	public List<Ticket> getPendingTicketByManagerId(Integer managerId){
		return this.ticketDAO.getPendingTicketByManagerId(managerId);
	}
	
	
	@Override
	@Transactional
	public void assignTicket(Integer ticketId,Integer userId) {
		Ticket ticket=this.getTicketById(ticketId);
		ticket.setAssignmentTime(new Date());
	    ticket.setAssignedTo(userId);
	    this.updateTicket(ticket);
		
	}
	@Override
	@Transactional
	public void closeTicket(Integer ticketId,Integer userId) {
		Ticket ticket=this.getTicketById(ticketId);
		ticket.setClosingTime(new Date());
	    ticket.setAssignedTo(userId);
	    this.updateTicket(ticket);
		
	}

}
