package com.qa.hq;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hq.domain.Ticket;
import com.qa.hq.domain.Trainee;
import com.qa.hq.domain.Trainer;

import nl.jqno.equalsverifier.EqualsVerifier;


@SpringBootTest
@ActiveProfiles(profiles = "test")
class HelpQueueApplicationTests {

	@Test
	void contextLoads() {
	}
	
	/*
	@Test
	void TestEqualsVerifier() {
		EqualsVerifier.forClass(Trainer.class).usingGetClass().verify();
		EqualsVerifier.forClass(Trainee.class).usingGetClass().verify();
		EqualsVerifier.forClass(Ticket.class).usingGetClass().verify();
	}
	*/
}
