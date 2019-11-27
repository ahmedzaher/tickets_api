package com.helpdesk.tickets_api.service;

import com.helpdesk.tickets_api.model.Ticket;
import com.helpdesk.tickets_api.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getUserTickets(Long userId) {
        return this.ticketRepository.findByCreatorIdOrderByCreatedAtDesc(userId);
    }

    public Ticket addTicket(Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }

    public Ticket editTicket(Ticket ticket) {
        return this.ticketRepository.save(ticket);
    }
}
