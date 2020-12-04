package com.qa.HP.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.HP.domain.Ticket;
import com.qa.HP.service.TicketService;
import com.qa.HP.service.TicketService;

public class TicketController {
	
	private TicketService service;

	private TicketController(TicketService service) {
		super();
		this.service = service;
	}

	@PostMapping("/ticket/create")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		return new ResponseEntity<Ticket>(this.service.createTicket(ticket), HttpStatus.CREATED);
	}

	@GetMapping("/ticket/getAll")
	public ResponseEntity<List<Ticket>> getTicket() {
		return ResponseEntity.ok(this.service.getTicket());
	}

	@DeleteMapping("/ticket/remove/{id}")
	public ResponseEntity<Object> deleteTicket(@PathVariable Long id) {
		if (this.service.deleteTicket(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/ticket/update")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathParam("id") Long id) {
		return new ResponseEntity<Ticket>(this.service.updateTicket(ticket, id), HttpStatus.ACCEPTED);
	}

}
