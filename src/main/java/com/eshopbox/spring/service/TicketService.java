package com.eshopbox.spring.service;

import java.util.List;

import com.eshopbox.spring.model.Ticket;

public interface TicketService {

	public void addTicket(Ticket p);
	public void updateTicket(Ticket p);
	public List<Ticket> listTickets();
	public Ticket getTicketById(int id);
	public void removeTicket(int id);
	
}
