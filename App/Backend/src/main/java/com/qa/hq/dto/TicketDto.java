package com.qa.hq.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.qa.hq.domain.Ticket;
import com.qa.hq.domain.Trainee;

public class TicketDto {

	private Long id;
	private String title;
	private String issue;
	private String topic;
	private Date submitDate;
	private int urgency;
	private String status;
	private Long trainerId;
	private List<Long> traineeIds;
	
	public TicketDto(Ticket ticket) {
		super();
		setId(ticket.getId());
		setTitle(ticket.getTitle());
		setIssue(ticket.getIssue());
		setTopic(ticket.getTopic());
		setSubmitDate(ticket.getSubmitDate());
		setUrgency(ticket.getUrgency());
		setStatus(ticket.getStatus());
		if(ticket.getTrainer() != null) {
		setTrainerId(ticket.getTrainer().getId());
		}
		if(ticket.getTrainees() != null) {
		setTraineeIds(ticket.getTrainees().stream().map( (trainee) -> trainee.getId()).collect(Collectors.toList()));
		}
	}
	
	@Override
	public String toString() {
		return "TicketDto [id=" + id + ", title=" + title + ", issue=" + issue + ", topic=" + topic + ", submitDate="
				+ submitDate + ", urgency=" + urgency + ", status=" + status + ", trainerId=" + trainerId
				+ ", traineeIds=" + traineeIds + "]";
	}

	public TicketDto(Long id, String title, String issue, String topic, Date submitDate, int urgency, String status, Long trainerId, List<Long> traineeIds) {
		super();
		setId(id);
		setTitle(title);
		setIssue(issue);
		setTopic(topic);
		setSubmitDate(submitDate);
		setUrgency(urgency);
		setStatus(status);
		setTrainerId(trainerId);
		setTraineeIds(traineeIds);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
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

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public List<Long> getTraineeIds() {
		return traineeIds;
	}

	public void setTraineeIds(List<Long> traineeIds) {
		this.traineeIds = traineeIds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((issue == null) ? 0 : issue.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + ((traineeIds == null) ? 0 : traineeIds.hashCode());
		result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
		result = prime * result + urgency;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketDto other = (TicketDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issue == null) {
			if (other.issue != null)
				return false;
		} else if (!issue.equals(other.issue))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (traineeIds == null) {
			if (other.traineeIds != null)
				return false;
		} else if (!traineeIds.equals(other.traineeIds))
			return false;
		if (trainerId == null) {
			if (other.trainerId != null)
				return false;
		} else if (!trainerId.equals(other.trainerId))
			return false;
		if (urgency != other.urgency)
			return false;
		return true;
	}
	
}
