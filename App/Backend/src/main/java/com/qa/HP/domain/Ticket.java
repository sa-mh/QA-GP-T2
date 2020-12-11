package com.qa.HP.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;

	private String title;
	private String issue;
	private String topic;
	private String submitDate;
	private int urgency;
	private String status;
	private int traineeId;
	private int trainerId;
	

	public Ticket() {
		super();
	}

	public Ticket(String title, String issue, String topic, String submitDate, int urgency, String status, int traineeId, int trainerId) {
		super();
		this.title = title;
		this.issue = issue;
		this.topic = topic;
		this.submitDate = submitDate;
		this.urgency = urgency;
		this.status = status;
		this.traineeId = traineeId;
		this.trainerId = trainerId;
	}
	
	public Long getTicketId() {
		return ticketId;
	}
	
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public int getUrgency() {
		return urgency;
	}

	public void setUrgency(int urgency) {
		this.urgency = urgency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	
	// needs Hashcode and equals override for testing

}
