package com.qa.hq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.hq.domain.Ticket;

import nl.jqno.equalsverifier.EqualsVerifier;


@SpringBootTest
class HelpQueueApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void TicketTestCoverage() {
		EqualsVerifier.forClass(Ticket.class).usingGetClass().verify();
	}
}
