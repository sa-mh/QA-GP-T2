package com.qa.HP.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.HP.domain.Ticket;
import com.qa.HP.domain.Trainee;
import com.qa.HP.domain.Trainer;
import com.qa.HP.service.TraineeService;

@RestController
@CrossOrigin
@RequestMapping("/trainee")
public class TraineeController {
	
	private TraineeService service;

	private TraineeController(TraineeService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee) {
		return new ResponseEntity<Trainee>(this.service.createTrainee(trainee), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Trainee>> getTrainees() {
		return ResponseEntity.ok(this.service.getTrainees());
	}
	
	@GetMapping("/findById")
	public ResponseEntity<Trainee> getTraineeById(Long traineeId) {
		return ResponseEntity.ok(this.service.getTraineeById(traineeId));
	}
	
	@GetMapping("/findByCohort/{cohort}")
	public ResponseEntity<List<Trainee>> findTraineeByCohort(@PathVariable String cohort) {
		return ResponseEntity.ok(this.service.findTraineeByCohort(cohort));
	}

	//@PutMapping("/update")
	//public ResponseEntity<Trainee> updateTicket(@RequestBody Trainee trainee, @PathParam("id") Long traineeId) {

	//@PutMapping("/update")
	//public ResponseEntity<Trainee> updateTicket(@RequestBody Trainee trainee, @PathParam("id") Long id) {
	//	return new ResponseEntity<Trainee>(this.service.updateTrainee(trainee, id), HttpStatus.ACCEPTED);
	//}

}
