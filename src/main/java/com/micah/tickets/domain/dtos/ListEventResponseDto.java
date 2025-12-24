package com.micah.tickets.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.micah.tickets.domain.entities.EventStatusEnum;

public record ListEventResponseDto(
        UUID id,
        String name,
        LocalDateTime start,
        LocalDateTime end,
        String venue,
        LocalDateTime salesStart,
        LocalDateTime salesEnd,
        EventStatusEnum status,
        List<ListEventTicketTypeResponseDto> ticketTypes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
