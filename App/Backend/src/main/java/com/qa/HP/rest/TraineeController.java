package com.qa.HP.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.HP.domain.Trainee;
import com.qa.HP.service.TraineeService;

public class TraineeController {
	
	private TraineeService service;

	private TraineeController(TraineeService service) {
		super();
		this.service = service;
	}

	//Create a trainee- signing up
	@PostMapping("/trainee/create")
	public ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee) {
		return new ResponseEntity<Trainee>(this.service.createTrainee(trainee), HttpStatus.CREATED);
	}
	//Get trainee name when signing in
	@GetMapping("/trainee/getAll")
	public ResponseEntity<List<Trainee>> getTrainee() {
		return ResponseEntity.ok(this.service.getTrainee());
	}

	//@PutMapping("/trainee/update")
	//public ResponseEntity<Trainee> updateTicket(@RequestBody Trainee trainee, @PathParam("id") Long id) {
	//	return new ResponseEntity<Trainee>(this.service.updateTrainee(trainee, id), HttpStatus.ACCEPTED);
	//}

}
