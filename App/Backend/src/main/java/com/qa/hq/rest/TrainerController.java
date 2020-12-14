package com.qa.hq.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hq.domain.Trainer;
import com.qa.hq.service.TrainerService;

@RestController
@CrossOrigin
@RequestMapping("/trainer")
public class TrainerController {
	
	private TrainerService service;
	
	public TrainerController(TrainerService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Trainer>> getTrainers() {
		return ResponseEntity.ok(this.service.getTrainers());
	}
	
	@GetMapping("/findById")
	public ResponseEntity<Trainer> findTrainerById(Long trainerId) {
		return ResponseEntity.ok(this.service.findTrainerById(trainerId));
	}
		
	@PostMapping("/create")
	public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
		return new ResponseEntity<Trainer>(this.service.createTrainer(trainer), HttpStatus.CREATED);
	}

}
