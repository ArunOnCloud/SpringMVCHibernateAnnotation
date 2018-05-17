package com.eshopbox.spring.dao;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshopbox.spring.model.Employee;
import com.eshopbox.spring.model.Ticket;

@Repository("ticketDAO")
public class TicketDAOImpl implements TicketDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TicketDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public void addTicket(Ticket p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Ticket saved successfully, Ticket Details="+p);
	}

	@Override
	public void updateTicket(Ticket p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Ticket updated successfully, Ticket Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> listTickets() {
		Session session = this.sessionFactory.getCurrentSession();
		//Session session = this.sessionFactory.openSession();
		try{
			List<Ticket> ticketsList = session.createQuery("from Ticket").list();
			for(Ticket p : ticketsList){
				logger.info("Ticket List::"+p);
			}
			return ticketsList;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return new LinkedList<Ticket>();
	}

	@Override
	public Ticket getTicketById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Ticket p = (Ticket) session.load(Ticket.class, new Integer(id));
		logger.info("Ticket loaded successfully, Ticket details="+p);
		return p;
	}

	@Override
	public void removeTicket(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Ticket p = (Ticket) session.load(Ticket.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Ticket deleted successfully, ticket details="+p);
	}
	
	@Override
	public List<Ticket> getTicketByManagerId(Integer managerId) {
		Session session = this.sessionFactory.getCurrentSession();		
		Criteria cr = session.createCriteria(Ticket.class);
		cr.add(Restrictions.eq("createdBy",managerId));
		return cr.list();
		
	}
	@Override
	public List<Ticket> getPendingTicketByManagerId(Integer managerId) {
		Session session = this.sessionFactory.getCurrentSession();		
		Criteria cr = session.createCriteria(Ticket.class);
		cr.add(Restrictions.eq("createdBy",managerId));
		//cr.add(Restrictions.isEmpty("closeBy"));
		cr.add(Restrictions.isNull("closeBy"));
		return cr.list();
		
	}
	
	

}
