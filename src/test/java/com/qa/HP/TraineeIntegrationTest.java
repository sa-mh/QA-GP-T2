package com.qa.HP;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.HP.domain.Ticket;
import com.qa.HP.domain.Trainee;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:trainee-schema.sql",
"classpath:trainee-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class TraineeIntegrationTest {

	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void getTraineeTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainee trainee = new Trainee("A username", "First name", "Last name", "A cohort", "A password", "An email", tickets);
		trainee.setId(1L);
		List<Trainee> trainees = new ArrayList<>();
		trainees.add(trainee);
		String getResponseBody = this.mapper.writeValueAsString(trainee);
		
		this.mockMVC.perform(get("/getAll")).andExpect(status().isOk()).andExpect(content().json(getResponseBody));
	}
	
	@Test
	void createTraineeTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainee newTrainee = new Trainee("A username", "First name", "Last name", "A cohort", "A password", "An email", tickets);
		String body = this.mapper.writeValueAsString(newTrainee);
		RequestBuilder createRequestBody = post("/trainee/create").contentType(MediaType.APPLICATION_JSON).content(body);
		ResultMatcher checkStatus = status().isCreated();
		Trainee savedTrainee = new Trainee("A username", "First name", "Second name", "A cohort", "A password", "An email", tickets);
		savedTrainee.setId(2L);
		String resultBody = this.mapper.writeValueAsString(savedTrainee);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(createRequestBody).andExpect(checkStatus).andExpect(checkBody);
		MvcResult result = this.mockMVC.perform(createRequestBody).andExpect(checkStatus).andReturn();
	}
	
	@Test
	void findTraineeByIdTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainee trainee = new Trainee("A username", "First name", "Last name", "A cohort", "A password", "An email", tickets);
		Long traineeId = 1L;
		List<Trainee> trainees = new ArrayList<>();
		trainees.add(trainee);
		String responseBody = this.mapper.writeValueAsString(trainee);
		RequestBuilder request = get("/trainee/findById/" + traineeId).contentType(MediaType.APPLICATION_JSON).content(responseBody);
		ResultMatcher checkStatus = status().isOk();
		
		this.mockMVC.perform(request).andExpect(checkStatus);
	}
	
	@Test
	void findTraineeByCohortTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainee trainee = new Trainee("A username", "First name", "Last name", "A cohort", "A password", "An email", tickets);
		String cohort = "Cloud Native";
		List<Trainee> trainees = new ArrayList<>();
		trainees.add(trainee);
		String responseBody = this.mapper.writeValueAsString(trainee);
		RequestBuilder request = get("/trainee/findByCohort/" + cohort).contentType(MediaType.APPLICATION_JSON).content(responseBody);
		ResultMatcher checkStatus = status().isOk();
		
		this.mockMVC.perform(request).andExpect(checkStatus);
	}
	
	@Test
	void findTraineeByUsernameTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainee trainee = new Trainee("A username", "First name", "Last name", "A cohort", "A password", "An email", tickets);
		String username = "username1";
		List<Trainee> trainees = new ArrayList<>();
		trainees.add(trainee);
		String responseBody = this.mapper.writeValueAsString(trainee);
		RequestBuilder request = get("/trainee/findByUsername/" + username).contentType(MediaType.APPLICATION_JSON).content(responseBody);
		ResultMatcher checkStatus = status().isOk();
		
		this.mockMVC.perform(request).andExpect(checkStatus);
	}
	
}
