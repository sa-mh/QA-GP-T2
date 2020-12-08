package com.qa.HP.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.HP.domain.Trainer;
import com.qa.HP.domain.TrainerRepo;

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
	
	public Trainer getTrainerById(Long trainerId) {
		return this.repo.findById(trainerId).get();
	}
	
	public Trainer createTrainer(Trainer trainer) {
		return this.repo.save(trainer);
	}
	
}
