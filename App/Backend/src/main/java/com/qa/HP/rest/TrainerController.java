package com.qa.HP.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.HP.domain.Trainer;
import com.qa.HP.service.TrainerService;

// This class deals with requests
public class TrainerController {
	
	private TrainerService service;
	
	public TrainerController(TrainerService service) {
		super();
		this.service = service;
	}
	
	//Get request
	@GetMapping("/trainer/getAll")
	public ResponseEntity<List<Trainer>> getTrainer() {
		return ResponseEntity.ok(this.service.getTrainer());
	}
		
	@PostMapping("/trainer/create")
	public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
		return new ResponseEntity<Trainer>(this.service.createTrainer(trainer), HttpStatus.CREATED);
	}

}
