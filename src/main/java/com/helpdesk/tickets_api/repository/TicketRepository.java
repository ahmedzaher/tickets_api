package com.helpdesk.tickets_api.repository;

import com.helpdesk.tickets_api.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByCreatorIdOrderByCreatedAtDesc(Long creatorId);
}
