package com.qa.HP.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long traineeId;

	private String username;
	private String firstName;
	private String secondName;
	private String cohort;
	private String password;
	private String traineeEmail;

	public Trainee() {
		super();
	}

	public Trainee(String username, String firstName, String secondName, String cohort, String password, String traineeEmail) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.secondName = secondName;
		this.cohort = cohort;
		this.password = password;
		this.traineeEmail = traineeEmail;
	}

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long id) {
		this.traineeId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return traineeEmail;
	}
	
	public void setTraineeEmail(String traineeEmail) {
		this.traineeEmail = traineeEmail;
	}
	
	// needs Hashcode and equals override for testing

}
