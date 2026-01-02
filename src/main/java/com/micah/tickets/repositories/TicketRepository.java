package com.micah.tickets.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micah.tickets.domain.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    int countByTicketTypeId(UUID ticketTypeId);
}
