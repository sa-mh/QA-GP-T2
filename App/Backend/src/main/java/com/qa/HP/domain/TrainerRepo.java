
package com.qa.HP.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// JPA allows java to communicate to DB
public interface TrainerRepo extends JpaRepository<Trainer, Long> {

	List<Trainer> findByUsername(String username);
}
