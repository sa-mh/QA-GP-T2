package App.Backend.src.main.java.com.qa.HP.rest;

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

import App.Backend.src.main.java.com.qa.HP.domain.Ticket;
import App.Backend.src.main.java.com.qa.HP.domain.Trainee;
import App.Backend.src.main.java.com.qa.HP.domain.Trainer;
import App.Backend.src.main.java.com.qa.HP.service.TraineeService;

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
	public ResponseEntity<Trainee> findTraineeById(Long id) {
		return ResponseEntity.ok(this.service.findTraineeById(id));
	}
	
	@GetMapping("/findByTrainee/{id}") 
	public ResponseEntity<List<Ticket>> findTicketByTrainee(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.findTicketByTrainee(id));
	}
	
	@GetMapping("/findByCohort/{cohort}")
	public ResponseEntity<List<Trainee>> findTraineeByCohort(@PathVariable String cohort) {
		return ResponseEntity.ok(this.service.findTraineeByCohort(cohort));
	}
	
	@GetMapping("/findByUsername/{username}")
	public ResponseEntity<List<Trainee>> findTraineeByUsername(@PathVariable String username) {
		return ResponseEntity.ok(this.service.findTraineeByUsername(username));
	}

	//@PutMapping("/update")
	//public ResponseEntity<Trainee> updateTicket(@RequestBody Trainee trainee, @PathParam("id") Long id) {

	//@PutMapping("/update")
	//public ResponseEntity<Trainee> updateTicket(@RequestBody Trainee trainee, @PathParam("id") Long id) {
	//	return new ResponseEntity<Trainee>(this.service.updateTrainee(trainee, id), HttpStatus.ACCEPTED);
	//}

}
