package com.qa.HP.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.HP.domain.Trainee;
import com.qa.HP.service.TraineeService;

@RestController
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
	public ResponseEntity<List<Trainee>> getTrainee() {
		return ResponseEntity.ok(this.service.getTrainee());
	}

	//@PutMapping("/update")
	//public ResponseEntity<Trainee> updateTicket(@RequestBody Trainee trainee, @PathParam("id") Long id) {
	//	return new ResponseEntity<Trainee>(this.service.updateTrainee(trainee, id), HttpStatus.ACCEPTED);
	//}

}
