package com.micah.tickets.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.micah.tickets.domain.entities.EventStatusEnum;

public record GetEventDetailsResponseDto(
        UUID id,
        String name,
        LocalDateTime start,
        LocalDateTime end,
        String venue,
        LocalDateTime salesStart,
        LocalDateTime salesEnd,
        EventStatusEnum status,
        List<GetEventDetailsTicketTypeResponseDto> ticketTypes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
