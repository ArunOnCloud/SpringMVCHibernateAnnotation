package com.eshopbox.spring.dao;

import java.util.List;

import com.eshopbox.spring.model.Ticket;

public interface TicketDAO {

	public void addTicket(Ticket p);
	public void updateTicket(Ticket p);
	public List<Ticket> listTickets();
	public Ticket getTicketById(int id);
	public void removeTicket(int id);
}
