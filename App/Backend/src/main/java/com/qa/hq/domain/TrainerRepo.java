package com.qa.hq.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {

	Trainer findByUsername(String username);
}
