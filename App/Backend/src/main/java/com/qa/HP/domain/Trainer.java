package com.qa.HP.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainerId;
	
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String field;
	private String trainerEmail;
	
	
	public Trainer(String username, String firstName, String lastName, String password, String field, String trainerEmail) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.field = field;
		this.trainerEmail = trainerEmail;
	}
	
	public Trainer() { 
		super();

	}
	
	@Override
	public String toString() {
		return "Trainers [id=" + trainerId + ", username=" + username + "firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", field=" + field + ", trainer email=" + trainerEmail + "]";
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username ) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field= field;
	}
	
	public String getTrainerEmail() {
		return trainerEmail;
	}
	
	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

}
