package com.qa.hq.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hq.domain.Trainer;
import com.qa.hq.domain.TrainerRepo;
import com.qa.hq.service.TrainerService;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class TrainerUnitTest {
	@Autowired
	private TrainerService tService;
	
	@MockBean
	private TrainerRepo tRepo;
	
	@Test
	void testCreateTrainer() {
		// Given a new Trainer is added (ID 1)
		long ID = 1;
		Trainer newTrainer = new Trainer("DD", "Dummy", "Data", "DummyPass", "Dev Ops", "DD@Test.com", null);
		Trainer savedTrainer = new Trainer("DD", "Dummy", "Data", "DummyPass", "Dev Ops", "DD@Test.com", null);
		savedTrainer.setId(ID);
		
		// When the function is called to save the Trainer
		Mockito.when(this.tRepo.save(newTrainer)).thenReturn(savedTrainer);	
	
		// Then check that the Trainer is saved correctly.
		assertThat(this.tService.createTrainer(newTrainer)).isEqualTo(savedTrainer);
	
		Mockito.verify(this.tRepo,Mockito.times(1)).save(newTrainer);
	}
	
	@Test
	void testGetAllTrainers() {
		// Given there are two trainers, with ID's 1 & 2
		long ID = 1;
		Trainer trainer1 = new Trainer("DD", "Dummy", "Data", "DummyPass", "Dev Ops", "DD@Test.com", null);
		trainer1.setId(ID++);
		Trainer trainer2 = new Trainer("D0", "Debora", "Data", "DummyP4ss", "Cloud Native", "DebD@Test.com", null);
		trainer2.setId(ID);
		
		List<Trainer> TrainerList = new ArrayList<>();
		TrainerList.add(trainer1);
		TrainerList.add(trainer2);
			
		// When the function is called to get all the trainers
		Mockito.when(this.tRepo.findAll()).thenReturn(TrainerList);
		
		// Then check that the Trainers are all there.
		assertThat(this.tService.getTrainers()).isEqualTo(TrainerList);

		Mockito.verify(this.tRepo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testFindTrainerById() {
		// Given there are three trainers, with ID's 1, 2 & 3
		long ID = 1;
		Trainer trainer1 = new Trainer("DD", "Dummy", "Data", "DummyPass", "Dev Ops", "DD@Test.com", null);
		trainer1.setId(ID++);
		Trainer trainer2 = new Trainer("Y0UL00K1N4M3", "Cannot", "Findme", "Cr4Ck-tHiS", "Software Engineering", "Hackerman@Realmail.com", null);
		trainer2.setId(ID++);
		Trainer trainer3 = new Trainer("D0", "Debora", "Data", "DummyP4ss", "Cloud Native", "DebD@Test.com", null);
		trainer3.setId(ID);
		
		List<Trainer> TrainerList = new ArrayList<>();
		TrainerList.add(trainer1);
		TrainerList.add(trainer2);
		TrainerList.add(trainer3);
			
		// When the function is called to get the 2nd trainer
		Mockito.when(this.tRepo.findById(2L)).thenReturn(Optional.of(TrainerList.get(1)));
		
		// Then check that the correct trainer is retrieved
		assertThat(this.tService.findTrainerById(2L)).isEqualTo(trainer2);
		Mockito.verify(this.tRepo, Mockito.times(1)).findById(2L);	
	}
	
	@Test
	void findTrainerByUsername() {
		// Given there are three trainers, with ID's 1, 2 & 3
		long ID = 1;
		Trainer trainer1 = new Trainer("DD", "Dummy", "Data", "DummyPass", "Dev Ops", "DD@Test.com", null);
		trainer1.setId(ID++);
		Trainer trainer2 = new Trainer("Y0UL00K1N4M3", "Cannot", "Findme", "Cr4Ck-tHiS", "Software Engineering", "Hackerman@Realmail.com", null);
		trainer2.setId(ID++);
		Trainer trainer3 = new Trainer("D0", "Debora", "Data", "DummyP4ss", "Cloud Native", "DebD@Test.com", null);
		trainer3.setId(ID);
		
		List<Trainer> TrainerList = new ArrayList<>();
		TrainerList.add(trainer1);
		TrainerList.add(trainer2);
		TrainerList.add(trainer3);
			
		// When the function is called to get the 2nd trainer
		Mockito.when(this.tRepo.findByUsername("Y0UL00K1N4M3")).thenReturn(TrainerList.get(1));
		
		// Then check that the correct trainer is retrieved
		assertThat(this.tService.findTrainerByUsername("Y0UL00K1N4M3")).isEqualTo(trainer2);
		Mockito.verify(this.tRepo, Mockito.times(1)).findByUsername("Y0UL00K1N4M3");	
	}
}