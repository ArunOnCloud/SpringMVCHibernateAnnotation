package com.eshopbox.spring.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@Column(name="ticketId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ticketId;
	
	private String summary;
	private String description;
	private Integer type;
	private Integer createdBy;
	private Date creationTime;
	private Integer assignedTo;
	private Date assignmentTime;
	private Integer closeBy;
	private Date closingTime;
	
	/*@ManyToOne
	@JoinColumn(name="createdBy", nullable=true)
	private Employee createdByEmployee;
	
	public Employee getCreatedByEmployee() {
		return createdByEmployee;
	}
	public void setCreatedByEmployee(Employee createdByEmployee) {
		this.createdByEmployee = createdByEmployee;
	}*/
	
	
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(Integer assignedTo) {
		this.assignedTo = assignedTo;
	}
	public Date getAssignmentTime() {
		return assignmentTime;
	}
	public void setAssignmentTime(Date assignmentTime) {
		this.assignmentTime = assignmentTime;
	}
	public Integer getCloseBy() {
		return closeBy;
	}
	public void setCloseBy(Integer closeBy) {
		this.closeBy = closeBy;
	}
	public Date getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", summary=" + summary + ", description=" + description + ", type="
				+ type + ", createdBy=" + createdBy + ", creationTime=" + creationTime + ", assignedTo=" + assignedTo
				+ ", assignmentTime=" + assignmentTime + ", closeBy=" + closeBy + ", closingTime=" + closingTime + "]";
	}
	
	
	

}
