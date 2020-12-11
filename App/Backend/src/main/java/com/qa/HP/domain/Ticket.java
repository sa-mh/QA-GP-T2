package com.qa.HP.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int ticketID;
	private String title;
	private String issue;
	private String topic;
	private String submitDate;
	private int urgency;
	private String status;
	private int traineeID;
	private int trainerID;
	

	public Ticket() {
		super();
	}

	public Ticket(int ticketID, String title, String issue, String topic, String submitDate, int urgency, String status, int traineeID, int trainerID) {
		super();
		this.ticketID = ticketID;
		this.title = title;
		this.issue = issue;
		this.topic = topic;
		this.submitDate = submitDate;
		this.urgency = urgency;
		this.status = status;
		this.traineeID = traineeID;
		this.trainerID = trainerID;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
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

	public int getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(int traineeID) {
		this.traineeID = traineeID;
	}

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}
	
	// needs Hashcode and equals override for testing

}
