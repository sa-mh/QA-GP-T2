package App.Backend.src.main.java.com.qa.HP.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {

	List<Trainer> findByUsername(String username);
}
