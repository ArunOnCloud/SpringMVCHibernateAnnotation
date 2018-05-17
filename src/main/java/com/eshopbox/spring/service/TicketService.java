package com.eshopbox.spring.service;

import java.util.List;

import com.eshopbox.spring.model.Ticket;

public interface TicketService {

	public void addTicket(Ticket p);
	public void updateTicket(Ticket p);
	public List<Ticket> listTickets();
	public Ticket getTicketById(int id);
	public void removeTicket(int id);
	public List<Ticket> getTicketByManagerId(Integer managerId);
	public List<Ticket> getPendingTicketByManagerId(Integer managerId) ;
	public void assignTicket(Integer ticketId,Integer userId) ;
	public void closeTicket(Integer ticketId,Integer userId) ;
	
}
