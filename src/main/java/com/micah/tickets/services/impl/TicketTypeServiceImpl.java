package com.micah.tickets.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.micah.tickets.domain.entities.Ticket;
import com.micah.tickets.domain.entities.TicketStatusEnum;
import com.micah.tickets.domain.entities.TicketType;
import com.micah.tickets.domain.entities.User;
import com.micah.tickets.exceptions.TicketSoldOutException;
import com.micah.tickets.exceptions.TicketTypeNotFoundException;
import com.micah.tickets.exceptions.UserNotFoundException;
import com.micah.tickets.repositories.TicketRepository;
import com.micah.tickets.repositories.TicketTypeRepository;
import com.micah.tickets.repositories.UserRepository;
import com.micah.tickets.services.QrCodeService;
import com.micah.tickets.services.TicketTypeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final QrCodeService qrCodeService;

    @Override
    @Transactional
    public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with ID %s was not found", userId)));

        TicketType ticketType = ticketTypeRepository
                .findByIdWithLock(ticketTypeId)
                .orElseThrow(() -> new TicketTypeNotFoundException(
                        String.format("Ticket type with ID %s was not found", ticketTypeId)));

        int purchasedTickets = ticketRepository.countByTicketTypeId(ticketType.getId());
        Integer totalAvailable = ticketType.getTotalAvailable();

        if (purchasedTickets + 1 > totalAvailable) {
            throw new TicketSoldOutException();
        }

        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatusEnum.PURCHASED);
        ticket.setTicketType(ticketType);
        ticket.setPurchaser(user);

        Ticket savedTicket = ticketRepository.save(ticket);
        qrCodeService.generateQrCode(savedTicket);

        return savedTicket;

    }

}
