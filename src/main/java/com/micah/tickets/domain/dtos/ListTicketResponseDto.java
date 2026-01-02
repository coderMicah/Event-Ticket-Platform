package com.micah.tickets.domain.dtos;

import java.util.UUID;

import com.micah.tickets.domain.entities.TicketStatusEnum;

public record ListTicketResponseDto(
        UUID id,
        TicketStatusEnum status,
        ListTicketTicketTypeResponseDto ticketType) {

}
