package com.qa.hq.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.hq.domain.Trainer;
import com.qa.hq.domain.TrainerRepo;

@Service
public class TrainerService {
	
	private TrainerRepo repo;
	
	public TrainerService (TrainerRepo repo) {
		super();
		this.repo = repo;
	}
	
	public void setRepo(TrainerRepo repo) {
		this.repo = repo;
	}
	
	public List<Trainer> getTrainers() {
		return this.repo.findAll();	
	}
	
	public Trainer findTrainerById(Long id) {
		return this.repo.findById(id).get();
	}
	
	public Trainer findTrainerByUsername(String username) {
		return this.repo.findByUsername(username);
	}
	
	public Trainer createTrainer(Trainer trainer) {
		return this.repo.save(trainer);
	}
	
}
