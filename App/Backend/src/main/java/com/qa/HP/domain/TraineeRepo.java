package App.Backend.src.main.java.com.qa.HP.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepo extends JpaRepository<Trainee, Long> {
	
	List<Trainee> findByCohort(String cohort);
	List<Trainee> findByUsername(String username);
}
