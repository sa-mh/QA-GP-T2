package App.Backend.src.main.java.com.qa.HP.service;


import org.springframework.stereotype.Service;

import App.Backend.src.main.java.com.qa.HP.domain.Trainer;
import App.Backend.src.main.java.com.qa.HP.domain.TrainerRepo;

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
	
	public Trainer findTrainerById(Long trainerId) {
		return this.repo.findById(trainerId).get();
	}
	
	public List<Trainer> findTrainerByUsername(String username) {
		return this.repo.findByUsername(username);
	}
	
	public Trainer createTrainer(Trainer trainer) {
		return this.repo.save(trainer);
	}
	
}
