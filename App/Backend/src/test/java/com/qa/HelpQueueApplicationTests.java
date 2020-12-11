package App.Backend.src.test.java.com.qa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import App.Backend.src.main.java.com.qa.HP.domain.Ticket;

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
