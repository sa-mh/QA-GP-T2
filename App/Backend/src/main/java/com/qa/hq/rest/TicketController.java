package com.qa.hq.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hq.domain.Ticket;
import com.qa.hq.service.TicketService;

@RestController
@CrossOrigin
@RequestMapping("/ticket")
public class TicketController {
	
	private TicketService service;

	private TicketController(TicketService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		return new ResponseEntity<Ticket>(this.service.createTicket(ticket), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Ticket>> getTicket() {
		return ResponseEntity.ok(this.service.getTicket());
	}
	
	@GetMapping("/findById")
	public ResponseEntity<Ticket> findTicketById(Long id) {
		return ResponseEntity.ok(this.service.findTicketById(id));
	}
	
	@GetMapping("/findByTopic/{topic}")
	public ResponseEntity<List<Ticket>> findTicketByTopic(@PathVariable String topic) {
		return ResponseEntity.ok(this.service.findTicketByTopic(topic));
	}
	
	@GetMapping("/findByAuthor/{author}")
	public ResponseEntity<List<Ticket>> findTicketByAuthor(@PathVariable String author) {
		return ResponseEntity.ok(this.service.findTicketByAuthor(author));
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Ticket> deleteTicket(@PathVariable Long id) { //Object?
		if (this.service.deleteTicket(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathParam("id") Long id) {
		return new ResponseEntity<Ticket>(this.service.updateTicket(ticket, id), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/status/{id}")
	public ResponseEntity<Ticket> updateTicketStatus(@PathVariable Long id) {
		return new ResponseEntity<Ticket>(this.service.updateTicketStatus(id), HttpStatus.ACCEPTED);
	}
}
