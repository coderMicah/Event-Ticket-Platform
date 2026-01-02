package com.micah.tickets.services;

import java.util.UUID;

import com.micah.tickets.domain.entities.Ticket;

public interface TicketTypeService {
    Ticket purchaseTicket(UUID userId, UUID ticketTypeId);
}
