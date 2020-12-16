package com.qa.hq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hq.domain.Ticket;
import com.qa.hq.domain.Trainee;
import com.qa.hq.domain.Trainer;
import com.qa.hq.dto.TicketDto;

import nl.jqno.equalsverifier.EqualsVerifier;


@SpringBootTest
@ActiveProfiles(profiles = "test")
class HelpQueueApplicationTests {

	@Test
	void contextLoads() {
	}
	
	/*
	@Test
	void testTrainer() {
		EqualsVerifier.forClass(Trainer.class).usingGetClass().verify();
	}
	
	@Test
	void testTrainee() {
		EqualsVerifier.forClass(Trainee.class).usingGetClass().verify();
	}
	
	@Test
	void testTicket() {
		EqualsVerifier.forClass(Ticket.class).usingGetClass().verify();
	}
	
	@Test
	void testDto() {
		EqualsVerifier.forClass(TicketDto.class).usingGetClass().verify();
	}
	*/
}
