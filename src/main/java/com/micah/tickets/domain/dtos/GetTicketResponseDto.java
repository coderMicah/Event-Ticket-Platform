package com.micah.tickets.domain.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.micah.tickets.domain.entities.TicketStatusEnum;

public record GetTicketResponseDto(
                UUID id,
                TicketStatusEnum status,
                Double price,
                String description,
                String eventName,
                String eventVenue,
                LocalDateTime eventStart,
                LocalDateTime eventEnd) {
}