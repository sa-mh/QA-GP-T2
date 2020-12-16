package com.qa.hq.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hq.domain.Ticket;
import com.qa.hq.domain.TicketRepo;
import com.qa.hq.domain.Trainee;
import com.qa.hq.domain.Trainer;
import com.qa.hq.dto.TicketDto;
import com.qa.hq.exception.TicketNotFoundException;


@Service
public class TicketService {
	
	@Autowired
	private TicketRepo repo;

	private TicketService(TicketRepo repo) {
		super();
		this.repo = repo;
	}

	public List<TicketDto> getTicket() {
		return this.repo.findAll().stream().map(TicketDto::new).collect(Collectors.toList());
	}
	

	public TicketDto findTicketById(Long id) {
		Ticket ticket = this.repo.findById(id).get();
		TicketDto ticketDto = new TicketDto(ticket);
		return ticketDto;
	}
	
	public List<TicketDto> findTicketByStatus(String status) {
		return this.repo.findByStatus(status).stream().map(TicketDto::new).collect(Collectors.toList());
	}
	
	public TicketDto updateTicketStatus(Long id) {
		Ticket oldTicket = this.repo.findById(id).get();
		oldTicket.setStatus("Closed");
		Ticket statusReturn = this.repo.save(oldTicket);
		TicketDto ticketDto = new TicketDto(statusReturn);
		return ticketDto;
	}
	
	public List<TicketDto> findTicketByTopic(String topic) {
		return this.repo.findByTopic(topic).stream().map(TicketDto::new).collect(Collectors.toList());
	}

	public TicketDto createTicket(Ticket ticket) {
	    return new TicketDto(this.repo.save(ticket));
	}
	
	public TicketDto addTraineeToTicket(Long id, Trainee trainee) {
		Ticket oldTicket = this.repo.findById(id).get();
		oldTicket.addTrainee(trainee);
		this.repo.save(oldTicket);
		TicketDto ticketDto = new TicketDto(oldTicket);
		return ticketDto;
	}

	public boolean deleteTicket(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public TicketDto updateTicket(Ticket ticket, Long id) {
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
		TicketDto ticketDto = new TicketDto(updatedTicket);
		return ticketDto;
	}
	
} 

