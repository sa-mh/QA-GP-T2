package com.qa.hq.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hq.domain.Ticket;
   
import java.util.Date; 

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:/ticket-schema.sql", "classpath:/ticket-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)


@ActiveProfiles(profiles = "test")
public class TicketIntegrationTest {
	
		@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void getTicketTest() throws Exception {
		
		Date date = new Date(10L);
		Ticket ticket = new Ticket("A title", "An issue", "A topic", date, 4, "Open", "A Author");
		ticket.setId(1L);
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket);
		String getResponseBody = this.mapper.writeValueAsString(tickets);
		

		RequestBuilder request = get("/ticket/getAll").contentType(MediaType.APPLICATION_JSON).content(getResponseBody);

		ResultMatcher checkStatus = status().isOk();

		this.mockMVC.perform(request).andExpect(checkStatus);
	}
	
	@Test
	void getTicketByTopicTest() throws Exception {
		
		Date date = new Date(10L);
		Ticket ticket = new Ticket("A title", "An issue", "Dev Ops", date, 4, "Open", "Jim Henson");
		String topic = "Dev Ops";
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket);
		String responseBody = this.mapper.writeValueAsString(tickets);
		RequestBuilder request = get("/ticket/findByTopic/" + topic).contentType(MediaType.APPLICATION_JSON).content(responseBody);
		ResultMatcher checkStatus = status().isOk();
		
		this.mockMVC.perform(request).andExpect(checkStatus);
	}
	
	@Test
	void getTicketByAuthorTest() throws Exception {
		
		Date date = new Date(10L);
		Ticket ticket = new Ticket("A title", "An issue", "A Topic", date, 4, "Open", "Jim Henson");
		String author = "Jim Henson";
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket);
		String responseBody = this.mapper.writeValueAsString(tickets);
		RequestBuilder request = get("/ticket/findByAuthor/" + author).contentType(MediaType.APPLICATION_JSON).content(responseBody);
		ResultMatcher checkStatus = status().isOk();
		
		this.mockMVC.perform(request).andExpect(checkStatus);
	}
		
//	@Test
//	void createTicketTest() throws Exception {
//		
//		Date date = new Date();
//		
//		Ticket newTicket = new Ticket("A title", "An issue", "A Topic", date, 4, "Open", "Jim Henson");
//		
//		String body = this.mapper.writeValueAsString(newTicket);
//		RequestBuilder createRequestBody = post("/ticket/create").contentType(MediaType.APPLICATION_JSON).content(body);
//		ResultMatcher checkStatus = status().isCreated();
//		
//		Ticket savedTicket = new Ticket("A title", "An issue", "A Topic", date, 4, "Open", "Jim Henson");
//		savedTicket.setId(2L);
//		String resultBody = this.mapper.writeValueAsString(savedTicket);
//	
//		ResultMatcher checkBody = content().json(resultBody);
//		
//		this.mockMVC.perform(createRequestBody).andExpect(checkStatus).andExpect(checkBody);
//	}

	@Test
	void deleteTicketTest() throws Exception {
		
		Date date = new Date(10L);
		Ticket ticket = new Ticket("A title", "An issue", "A Topic", date, 4, "Open", "Jim Henson");
		ticket.setId(1L);
		RequestBuilder deleteRequest = delete("/ticket/remove/1");
		ResultMatcher checkStatus = status().is(200); 
		this.mockMVC.perform(deleteRequest).andExpect(checkStatus);
	}

	@Test
	void updateTicketTest() throws Exception {

		Date date = new Date(10L);
		Ticket newTicket = new Ticket("A title", "An issue", "A Topic", date, 4, "Open", "Jim Henson");
		String body = this.mapper.writeValueAsString(newTicket);
		RequestBuilder updateRequestBody = put("/ticket/update?id=1").contentType(MediaType.APPLICATION_JSON).content(body);
		ResultMatcher checkStatus = status().isAccepted();
		Ticket savedTicket = new Ticket("A title", "An issue", "A Topic", date, 4, "Open", "Jim Henson");
		savedTicket.setId(1L);
		String resultBody = this.mapper.writeValueAsString(savedTicket);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(updateRequestBody).andExpect(checkStatus).andExpect(checkBody);
	}

}

