package com.eshopbox.spring.service;

import java.util.List;

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

}
