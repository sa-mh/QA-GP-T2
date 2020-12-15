package com.qa.hq.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Long> {
	
	List<Ticket> findByTopic(String topic); 
	List<Ticket> findByStatus(String status);
	//List<Ticket> findByTraineeId(Long id);
	//Ticket addTraineeToTicket(Long id);
}
