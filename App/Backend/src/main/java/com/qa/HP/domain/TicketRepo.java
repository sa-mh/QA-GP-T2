package com.qa.HP.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//JPA allows java to communicate to DB
public interface TicketRepo extends JpaRepository<Ticket, Long> {

}
