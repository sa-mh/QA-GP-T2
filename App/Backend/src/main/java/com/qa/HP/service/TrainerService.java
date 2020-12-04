package com.qa.HP.service;

import java.util.List;

import com.qa.HP.domain.Trainer;
import com.qa.HP.domain.TrainerRepo;

public class TrainerService {
	
	private TrainerRepo repo;
	
	public TrainerService (TrainerRepo repo) {
		super();
		this.repo = repo;
	}
	

	public void setRepo(TrainerRepo repo) {
		this.repo = repo;
	}
	
	//Get request
		public List<Trainer> getTrainer() {
			return this.repo.findAll();
			
		}
	
		public Trainer createTrainer(Trainer trainer) {
		return this.repo.save(trainer);
	}
	

}
