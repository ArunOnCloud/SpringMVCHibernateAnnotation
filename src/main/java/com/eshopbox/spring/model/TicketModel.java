package com.eshopbox.spring.model;

import java.sql.Date;

public class TicketModel {
	
    private Integer ticketId;
	
	private String summary;
	private  String description;
	private Integer type;
	private Integer createdBy;
	private Date creationTime;
	private Integer assignedTo;
	private Date assignmentTime;
	private Integer closeBy;
	private Date closingTime;
	public Integer getTicketId() {
		return ticketId;
	}
	public String getSummary() {
		return summary;
	}
	public String getDescription() {
		return description;
	}
	public Integer getType() {
		return type;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public Integer getAssignedTo() {
		return assignedTo;
	}
	public Date getAssignmentTime() {
		return assignmentTime;
	}
	public Integer getCloseBy() {
		return closeBy;
	}
	public Date getClosingTime() {
		return closingTime;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public void setAssignedTo(Integer assignedTo) {
		this.assignedTo = assignedTo;
	}
	public void setAssignmentTime(Date assignmentTime) {
		this.assignmentTime = assignmentTime;
	}
	public void setCloseBy(Integer closeBy) {
		this.closeBy = closeBy;
	}
	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}

}
