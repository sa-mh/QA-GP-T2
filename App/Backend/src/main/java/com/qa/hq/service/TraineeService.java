package com.qa.hq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hq.domain.Ticket;
import com.qa.hq.domain.Trainee;
import com.qa.hq.domain.TraineeRepo;
import com.qa.hq.domain.Trainer;

@Service
public class TraineeService {
	
	@Autowired
	private TraineeRepo repo;

	private TraineeService(TraineeRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Trainee> getTrainees() { 
		return this.repo.findAll();
	} 
	
	public List<Trainee> findTraineeByCohort(String cohort) {
		return this.repo.findByCohort(cohort);
	}
	
	public Trainee findTraineeByUsername(String username) {
		return this.repo.findByUsername(username);
	}
	
	public Trainee findTraineeById(Long id) {
		return this.repo.findById(id).get();
	}

	public Trainee createTrainee(Trainee trainee) {
		return this.repo.save(trainee);
	}

	public List<Ticket> findTicketByTrainee(Long id) {
		Trainee trainee = this.findTraineeById(id);
		return trainee.getTickets();
	}

//delete trainee
 // public boolean deleteTrainee(Long traineeId) {
	//	this.repository.deleteById(traineeId);
	//	return !this.repository.existsById(traineeId);
	//}

// update trainee
//	public Trainee updateTrainee(Trainee trainee, Long traineeId) {
//		Optional<Trainee> optTrainee = this.repository.findById(traineeId);
//		Trainee oldTrainee = optTrainee.orElseThrow(() -> new TraineeNotFoundException());

	//	oldTrainee.setTraineeID(trainee.getTraineeID());
	//  oldTrainee.setFirstName(trainee.getFirstName());
  //	oldTrainee.setSecondName(trainee.getSecondName());
  //  oldTrainee.setCohort(trainee.getCohort());
  //  oldTrainee.setPassword(trainee.getPassword());
    
	//	Trainee updatedTrainee = this.repository.save(oldTrainee);
	//	return updatedTrainee;

	//}
} 

