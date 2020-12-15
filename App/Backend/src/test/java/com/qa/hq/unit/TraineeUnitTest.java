package com.qa.hq.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hq.domain.Ticket;
import com.qa.hq.domain.TicketRepo;
import com.qa.hq.domain.Trainee;
import com.qa.hq.domain.TraineeRepo;
import com.qa.hq.domain.Trainer;
import com.qa.hq.service.TraineeService;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class TraineeUnitTest {
	@Autowired
	private TraineeService tService;
	
	@MockBean
	private TraineeRepo tRepo;
	
	@MockBean
	private Trainee tTrainee;
	
	@Test
	void testCreateTrainee() {
		// Given a new Trainee is added (ID 1)
		long ID = 1;
		Trainee newTrainee = new Trainee("DD", "Dummy", "Data", "Dev Ops", "DummyPass",  "DD@Test.com", null);
		Trainee savedTrainee = new Trainee("DD", "Dummy", "Data", "Dev Ops", "DummyPass", "DD@Test.com", null);
		savedTrainee.setId(ID);
		
		// When the function is called to save the Trainee
		Mockito.when(this.tRepo.save(newTrainee)).thenReturn(savedTrainee);	
	
		// Then check that the Trainee is saved correctly.
		assertThat(this.tService.createTrainee(newTrainee)).isEqualTo(savedTrainee);
	
		Mockito.verify(this.tRepo,Mockito.times(1)).save(newTrainee);
	}
	
	@Test
	void testGetAllTrainees() {
		// Given there are two Trainees, with ID's 1 & 2
		long ID = 1;
		Trainee Trainee1 = new Trainee("DD", "Dummy", "Data", "Dev Ops", "DummyPass",  "DD@Test.com", null);
		Trainee1.setId(ID++);
		Trainee Trainee2 = new Trainee("D0", "Debora", "Data", "Cloud Native", "DummyP4ss",  "DebD@Test.com", null);
		Trainee2.setId(ID);
		
		List<Trainee> TraineeList = new ArrayList<>();
		TraineeList.add(Trainee1);
		TraineeList.add(Trainee2);
			
		// When the function is called to get all the Trainees
		Mockito.when(this.tRepo.findAll()).thenReturn(TraineeList);
		
		// Then check that the Trainees are all there.
		assertThat(this.tService.getTrainees()).isEqualTo(TraineeList);

		Mockito.verify(this.tRepo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testFindTraineeById() {
		// Given there are three Trainees, with ID's 1, 2 & 3
		long ID = 1;
		Trainee Trainee1 = new Trainee("DD", "Dummy", "Data", "Dev Ops", "DummyPass", "DD@Test.com", null);
		Trainee1.setId(ID++);
		Trainee Trainee2 = new Trainee("Y0UL00K1N4M3", "Cannot", "Dev Ops", "Findme", "Software Engineering", "Hackerman@Realmail.com", null);
		Trainee2.setId(ID++);
		Trainee Trainee3 = new Trainee("D0", "Debora", "Data", "Cloud Native", "DummyP4ss", "DebD@Test.com", null);
		Trainee3.setId(ID);
		
		List<Trainee> TraineeList = new ArrayList<>();
		TraineeList.add(Trainee1);
		TraineeList.add(Trainee2);
		TraineeList.add(Trainee3);
			
		// When the function is called to get the 2nd Trainee
		Mockito.when(this.tRepo.findById(2L)).thenReturn(Optional.of(TraineeList.get(1)));
		
		// Then check that the correct Trainee is retrieved
		assertThat(this.tService.findTraineeById(2L)).isEqualTo(Trainee2);
		Mockito.verify(this.tRepo, Mockito.times(1)).findById(2L);	
	}
	
	@Test
	void testFindTraineeByUsername() {
		// Given there are three Trainees, with ID's 1, 2 & 3
		long ID = 1;
		Trainee Trainee1 = new Trainee("DD", "Dummy", "Data", "Dev Ops", "DummyPass", "DD@Test.com", null);
		Trainee1.setId(ID++);
		Trainee Trainee2 = new Trainee("Y0UL00K1N4M3", "Cannot", "Cr4Ck-tHiS", "Findme", "Software Engineering", "Hackerman@Realmail.com", null);
		Trainee2.setId(ID++);
		Trainee Trainee3 = new Trainee("D0", "Debora", "Data", "Cloud Native", "DummyP4ss", "DebD@Test.com", null);
		Trainee3.setId(ID);
		
		List<Trainee> TraineeList = new ArrayList<>();
		TraineeList.add(Trainee1);
		TraineeList.add(Trainee2);
		TraineeList.add(Trainee3);
			
		// When the function is called to get the 2nd Trainee
		Mockito.when(this.tRepo.findByUsername("Y0UL00K1N4M3")).thenReturn(TraineeList.get(1));
		
		// Then check that the correct Trainee is retrieved
		assertThat(this.tService.findTraineeByUsername("Y0UL00K1N4M3")).isEqualTo(Trainee2);
		Mockito.verify(this.tRepo, Mockito.times(1)).findByUsername("Y0UL00K1N4M3");	
	}
	
	@Test
	void testFindTraineesByCohort() {
		// Given there are three Trainees, with ID's 1, 2 & 3
		long ID = 1;
		Trainee Trainee1 = new Trainee("DD", "Dummy", "Data", "Dev Ops", "DummyPass", "DD@Test.com", null);
		Trainee1.setId(ID++);
		Trainee Trainee2 = new Trainee("Y0UL00K1N4M3", "Cannot", "Cloud Native", "Findme", "Software Engineering", "Hackerman@Realmail.com", null);
		Trainee2.setId(ID++);
		Trainee Trainee3 = new Trainee("D0", "Debora", "Data", "Dev Ops", "DummyP4ss", "DebD@Test.com", null);
		Trainee3.setId(ID);
		
		List<Trainee> TraineeList = new ArrayList<>();
		TraineeList.add(Trainee1);
		TraineeList.add(Trainee2);
		TraineeList.add(Trainee3);
		
		List<Trainee> ReturnList = new ArrayList<>();
		ReturnList.add(Trainee1);
		ReturnList.add(Trainee3);
			
		// When the function is called to get the 2nd Trainee
		Mockito.when(this.tRepo.findByCohort("Dev Ops")).thenReturn(ReturnList);
		
		// Then check that the correct Trainee is retrieved
		assertThat(this.tService.findTraineeByCohort("Dev Ops")).isEqualTo(ReturnList);
		Mockito.verify(this.tRepo, Mockito.times(1)).findByCohort("Dev Ops");	
	}
	
	@Test
	void testFindTicketByTrainee() {
		// Given there are 2 trainers with 3 tickets between them.
		List<Ticket> TicketsToReturn = new ArrayList<>();
		long TIID = 1;
		Date date = new Date(1245246L);
		Ticket Ticket1 = new Ticket("Help!", "Junit errors", "Bug", date, 4, "Open", null, null);
		Ticket1.setId(TIID++);
		TicketsToReturn.add(Ticket1);
		date = new Date(12434246L);
		Ticket Ticket2 = new Ticket("React Problems", "Cant open react", "React", date, 5, "Open", null, null);
		Ticket2.setId(TIID++);
		date = new Date(1523466L);
		Ticket Ticket3 = new Ticket("Cant format table", "SQL isn't working correctly", "SQL", date, 2, "Open", null, null);
		Ticket3.setId(TIID);
		TicketsToReturn.add(Ticket3);
		
		List<Trainee> Ticket1Tr = new ArrayList<>();
		List<Trainee> Ticket2Tr = new ArrayList<>();
		List<Ticket> TicketList1 = new ArrayList<>();
		List<Ticket> TicketList2 = new ArrayList<>();
		
		
		long TRID = 1;
		//Trainee 1 gets Ticket 1 and 3
		Trainee Trainee1 = new Trainee("DD", "Dummy", "Data", "Dev Ops", "DummyPass", "DD@Test.com", null);
		Trainee1.setId(TRID++);
		Ticket1Tr.add(Trainee1);
		Ticket1.setTrainees(Ticket1Tr);
		Ticket3.setTrainees(Ticket1Tr);
		TicketList1.add(Ticket1);
		TicketList1.add(Ticket3);
		Trainee1.setTickets(TicketList1);
		//Trainee 2 gets Ticket 2
		Trainee Trainee2 = new Trainee("Y0UL00K1N4M3", "Cannot", "Dev Ops", "Findme", "Software Engineering", "Hackerman@Realmail.com", null);
		Trainee2.setId(TRID++);
		Ticket2Tr.add(Trainee2);
		Ticket2.setTrainees(Ticket2Tr);
		TicketList2.add(Ticket2);
		Trainee2.setTickets(TicketList2);
		
		List<Trainee> TraineeList = new ArrayList<>();
		TraineeList.add(Trainee1);
		TraineeList.add(Trainee2);
					
		// When the function is called to get tickets from the 1st trainer
		Mockito.when(this.tRepo.findById(1L)).thenReturn(Optional.of(TraineeList.get(0)));
		Mockito.when(this.tTrainee.getTickets()).thenReturn(TicketsToReturn);
		// Then check that the correct tickets are returned.
		assertThat(this.tService.findTicketByTrainee(1L)).isEqualTo(TicketsToReturn);
		Mockito.verify(this.tRepo, Mockito.times(1)).findById(1L);	
	}
}