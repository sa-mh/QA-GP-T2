package com.qa.HP.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.HP.domain.Ticket;
import com.qa.HP.domain.TicketRepo;
import com.qa.HP.exception.TicketNotFoundException;


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
		oldTicket.setTraineeID(ticket.getTraineeID());
		oldTicket.setTrainerID(ticket.getTrainerID());

		Ticket updatedTicket = this.repo.save(oldTicket);
		return updatedTicket;

	}
} 

