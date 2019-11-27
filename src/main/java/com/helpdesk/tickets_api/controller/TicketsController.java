package com.helpdesk.tickets_api.controller;

import com.helpdesk.tickets_api.configuration.SystemUserDetails;
import com.helpdesk.tickets_api.model.Ticket;
import com.helpdesk.tickets_api.service.TicketService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketsController {

    private TicketService ticketService;

    TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getUserTickets() {
        Long userId = ((SystemUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getId();
        return this.ticketService.getUserTickets(userId);
    }

    @PostMapping
    public Ticket addUserTicket(@RequestBody Ticket ticket) {
        Long userId = ((SystemUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getId();
        ticket.setCreatorId(userId);
        return this.ticketService.addTicket(ticket);
    }

    @PutMapping("{ticket_id}")
    public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable("ticket_id") Long ticketId) {
        Long userId = ((SystemUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getId();
        ticket.setCreatorId(userId);
        ticket.setId(ticketId);
        return this.ticketService.addTicket(ticket);
    }
}
