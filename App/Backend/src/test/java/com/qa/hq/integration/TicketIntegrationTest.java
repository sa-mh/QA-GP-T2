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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hq.domain.Ticket;
import com.qa.hq.domain.Trainee;
import com.qa.hq.domain.Trainer;
import com.qa.hq.dto.TicketDto;

import java.sql.Timestamp;    
import java.util.Date; 

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:/sql/trainer-schema.sql", "classpath:/sql/trainee-schema.sql", "classpath:/sql/ticket-schema.sql", "classpath:/sql/trainee-ticket-schema.sql", "classpath:/sql/trainer-data.sql", "classpath:/sql/trainee-data.sql", "classpath:/sql/ticket-data.sql", "classpath:/sql/trainee-ticket-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)


@ActiveProfiles(profiles = "test")
public class TicketIntegrationTest {
	
	private String username="DD";
	private String firstName="Dummy";
	private String lastName="Data";
	private String password="NA";
	private String field="Dev Ops";
	private String trainerEmail="DD@Fake.com";
	private List<Ticket> ticketList;
	
	private String cohort="20SepCN";
	private String traineeEmail="EE@Fake.com";

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void getTicketTest() throws Exception {
		Trainer trainer = new Trainer(this.username,this.firstName,this.lastName,this.password,this.field,this.trainerEmail,this.ticketList);
		Trainee trainee = new Trainee(this.username,this.firstName,this.lastName,this.cohort,this.password,this.traineeEmail,this.ticketList);
		trainer.setId(1L);
		trainee.setId(1L);
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(trainee);
		Date date = new Date(10L);
		Ticket ticket = new Ticket("A title", "An issue", "A topic", date, 4, "Pending", trainer, trainees);
		ticket.setId(1L);
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket);
		TicketDto ticketDto = new TicketDto(ticket);
		String getResponseBody = this.mapper.writeValueAsString(tickets.stream().map(TicketDto::new).collect(Collectors.toList()));
		
		this.mockMVC.perform(get("/ticket/getAll")).andExpect(status().isOk()).andExpect(content().json(getResponseBody));
	}
	
	@Test
	void getTicketByTopicTest() throws Exception {
		Trainer trainer = new Trainer(this.username,this.firstName,this.lastName,this.password,this.field,this.trainerEmail,this.ticketList);
		List<Trainee> trainees = new ArrayList<Trainee>();
		Date date = new Date(10L);
		Ticket ticket = new Ticket("A title", "An issue", "A topic", date , 4, "Pending", trainer, trainees);
		String topic = "Dev Ops";
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(ticket);
		TicketDto ticketDto = new TicketDto(ticket);
		String responseBody = this.mapper.writeValueAsString(ticketDto);
		RequestBuilder request = get("/ticket/findByTopic/" + topic).contentType(MediaType.APPLICATION_JSON).content(responseBody);
		ResultMatcher checkStatus = status().isOk();
		
		this.mockMVC.perform(request).andExpect(checkStatus);
	}
	
	//This should be in TraineeIntegrationTest
//	@Test
//	void getTicketByTrainee() throws Exception {
//		Trainer trainer = new Trainer(this.username,this.firstName,this.lastName,this.password,this.field,this.trainerEmail,this.ticketList);
//		Trainee trainee = new Trainee(this.username,this.firstName,this.lastName,this.cohort,this.password,this.traineeEmail,this.ticketList);
//		List<Trainee> trainees = new ArrayList<Trainee>();
//		trainees.add(trainee);
//		Date date = new Date(10L);
//		Ticket ticket = new Ticket("A title", "An issue", "A topic", date, 4, "Pending", trainer, trainees);
//		Long traineeId = 1L;
//		List<Ticket> tickets = new ArrayList<>();
//		tickets.add(ticket);
//		TicketDto ticketDto = new TicketDto(ticket);
//		String responseBody = this.mapper.writeValueAsString(ticketDto);
//		RequestBuilder request = get("/ticket/findByTrainee/" + traineeId).contentType(MediaType.APPLICATION_JSON).content(responseBody);
//		ResultMatcher checkStatus = status().isOk();
//		
//		this.mockMVC.perform(request).andExpect(checkStatus);
//	}
		
	@Test
	void createTicketTest() throws Exception {
		Trainer trainer = new Trainer(this.username,this.firstName,this.lastName,this.password,this.field,this.trainerEmail,this.ticketList);
		Trainee trainee = new Trainee(this.username,this.firstName,this.lastName,this.cohort,this.password,this.traineeEmail,this.ticketList);
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(trainee);
		Date date = new Date(10L);
		
		Ticket newTicket = new Ticket("A title", "An issue", "A topic", date, 4, "Pending", trainer, trainees);
		newTicket.setId(1L);
		TicketDto ticketDto1 = new TicketDto(newTicket);
		
		String body = this.mapper.writeValueAsString(ticketDto1);
		RequestBuilder createRequestBody = post("/ticket/create").contentType(MediaType.APPLICATION_JSON).content(body);
		ResultMatcher checkStatus = status().isCreated();
		
		Ticket savedTicket = new Ticket("A title", "An issue", "A topic", date, 4, "Pending", trainer, trainees);
		savedTicket.setId(2L);
		TicketDto ticketDto2 = new TicketDto(savedTicket);
		String resultBody = this.mapper.writeValueAsString(ticketDto2);
	
		ResultMatcher checkBody = content().json(resultBody);
		
		this.mockMVC.perform(createRequestBody).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void deleteTicketTest() throws Exception {
		Trainer trainer = new Trainer(this.username,this.firstName,this.lastName,this.password,this.field,this.trainerEmail,this.ticketList);
		Trainee trainee = new Trainee(this.username,this.firstName,this.lastName,this.cohort,this.password,this.traineeEmail,this.ticketList);
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(trainee);
		Date date = new Date(10L);
		Ticket ticket = new Ticket("A title", "An issue", "A topic", date, 4, "Pending", trainer, trainees);
		ticket.setId(1L);
		RequestBuilder deleteRequest = delete("/ticket/remove/1");
		ResultMatcher checkStatus = status().is(200); 
		this.mockMVC.perform(deleteRequest).andExpect(checkStatus);
	}

	@Test
	void updateTicketTest() throws Exception {
		Trainer trainer = new Trainer(this.username,this.firstName,this.lastName,this.password,this.field,this.trainerEmail,this.ticketList);
		Trainee trainee = new Trainee(this.username,this.firstName,this.lastName,this.cohort,this.password,this.traineeEmail,this.ticketList);
		List<Trainee> trainees = new ArrayList<Trainee>();
		trainees.add(trainee);
		Date date = new Date(10L);
		trainer.setId(1L);
		Ticket newTicket = new Ticket("A title", "An issue", "A topic", date, 4, "Pending", trainer, trainees);
		String body = this.mapper.writeValueAsString(newTicket);
		RequestBuilder updateRequestBody = put("/ticket/update?id=1").contentType(MediaType.APPLICATION_JSON).content(body);
		ResultMatcher checkStatus = status().isAccepted();
		Ticket savedTicket = new Ticket("A title", "An issue", "A topic", date, 4, "Pending", trainer, trainees);
		savedTicket.setId(1L);
		TicketDto ticketDto = new TicketDto(savedTicket);
		String resultBody = this.mapper.writeValueAsString(ticketDto);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(updateRequestBody).andExpect(checkStatus).andExpect(checkBody);
	}

}

