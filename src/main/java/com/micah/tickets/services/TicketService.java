package com.micah.tickets.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.micah.tickets.domain.entities.Ticket;

public interface TicketService {
    Page<Ticket> listTicketsForUser(UUID userId, Pageable pageable);
}
