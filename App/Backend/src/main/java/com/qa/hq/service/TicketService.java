package com.qa.hq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hq.domain.Ticket;
import com.qa.hq.domain.TicketRepo;
import com.qa.hq.domain.Trainer;
import com.qa.hq.exception.TicketNotFoundException;


@Service
public class TicketService {
	
	@Autowired
	private TicketRepo repo;

	private TicketService(TicketRepo repo) {
		super();
		this.repo = repo;
	}

	public List<Ticket> getTicket() {
		return this.repo.findAll();
	}
	
	public Ticket findTicketById(Long id) {
		return this.repo.findById(id).get();
	}
	
	public List<Ticket> findTicketByStatus(String status) {
		return this.repo.findByTopic(status);
	}
	
	public Ticket updateTicketStatus(Long id) {
		Ticket oldTicket = this.repo.findById(id).get();
		oldTicket.setStatus("Closed");
		return this.repo.save(oldTicket);
	}
	
	public List<Ticket> findTicketByTopic(String topic) {
		return this.repo.findByTopic(topic);
	}
	
//	public List<Ticket> findTicketByTrainee(Long id) { 
//		return this.repo.findByTraineeId(id);
//	}

	public Ticket createTicket(Ticket ticket) {
		return this.repo.save(ticket);
	}

	public boolean deleteTicket(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public Ticket updateTicket(Ticket ticket, Long id) {
		Optional<Ticket> optTicket = this.repo.findById(id);
		Ticket oldTicket = optTicket.orElseThrow(() -> new TicketNotFoundException());

		oldTicket.setTitle(ticket.getTitle());
		oldTicket.setIssue(ticket.getIssue());
		oldTicket.setTopic(ticket.getTopic());
		oldTicket.setSubmitDate(ticket.getSubmitDate());
		oldTicket.setUrgency(ticket.getUrgency());
		oldTicket.setStatus(ticket.getStatus());
		oldTicket.setTrainer(ticket.getTrainer());
		oldTicket.setTrainees(ticket.getTrainees());

		Ticket updatedTicket = this.repo.save(oldTicket);
		return updatedTicket;
	}
	
} 

