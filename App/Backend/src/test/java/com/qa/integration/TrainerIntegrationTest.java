package App.Backend.src.test.java.com.qa.integration;

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
import App.Backend.src.main.java.com.qa.HP.domain.Ticket;
import App.Backend.src.main.java.com.qa.HP.domain.Trainee;
import App.Backend.src.main.java.com.qa.HP.domain.Trainer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:trainer-schema.sql",
"classpath:trainer-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class TrainerIntegrationTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void getTrainerTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainer trainer = new Trainer("A username", "First name", "Last name", "A password", "A field", "An email", tickets);
		trainer.setId(1L);
		List<Trainer> trainers = new ArrayList<>();
		trainers.add(trainer);
		String getResponseBody = this.mapper.writeValueAsString(trainer);
		
		this.mockMVC.perform(get("trainer/getAll")).andExpect(status().isOk()).andExpect(content().json(getResponseBody));
	}
	
	@Test
	void createTrainerTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainer newTrainer = new Trainer("A username", "First name", "Last name", "A password", "A field", "An email", tickets);
		String body = this.mapper.writeValueAsString(newTrainer);
		RequestBuilder createRequestBody = post("/trainee/create").contentType(MediaType.APPLICATION_JSON).content(body);
		ResultMatcher checkStatus = status().isCreated();
		Trainer savedTrainer = new Trainer("A username", "First name", "Last name", "A password", "A field", "An email", tickets);
		savedTrainer.setId(2L);
		String resultBody = this.mapper.writeValueAsString(savedTrainer);
		ResultMatcher checkBody = content().json(resultBody);
		
		this.mockMVC.perform(createRequestBody).andExpect(checkStatus).andExpect(checkBody);
		MvcResult result = this.mockMVC.perform(createRequestBody).andExpect(checkStatus).andReturn();
	}
	
	@Test
	void findTrainerByIdTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainer trainer = new Trainer("A username", "First name", "Last name", "A password", "A field", "An email", tickets);
		Long trainerId = 1L;
		List<Trainer> trainers = new ArrayList<>();
		trainers.add(trainer);
		String responseBody = this.mapper.writeValueAsString(trainer);
		RequestBuilder request = get("/trainer/findById/" + trainerId).contentType(MediaType.APPLICATION_JSON).content(responseBody);
		ResultMatcher checkStatus = status().isOk();
		
		this.mockMVC.perform(request).andExpect(checkStatus);
	}
	
	@Test
	void findTrainerByUsernameTest() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Trainer trainer = new Trainer("A username", "First name", "Last name", "A password", "A field", "An email", tickets);
		String username = "username1";
		List<Trainer> trainers = new ArrayList<>();
		trainers.add(trainer);
		String responseBody = this.mapper.writeValueAsString(trainer);
		RequestBuilder request = get("/trainer/findByUsername/" + username).contentType(MediaType.APPLICATION_JSON).content(responseBody);
		ResultMatcher checkStatus = status().isOk();
		
		this.mockMVC.perform(request).andExpect(checkStatus);
	}
}
