package com.micah.tickets.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.micah.tickets.domain.entities.EventStatusEnum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateEventRequestDto(
        @NotBlank(message = "Event name is required") String name,

        LocalDateTime start,

        LocalDateTime end,

        @NotBlank(message = "Venue details is required") String venue,

        LocalDateTime salesStart,

        LocalDateTime salesEnd,

        @NotNull(message = "Event status must be provided") EventStatusEnum status,

        @NotEmpty(message = "At least one ticket type is required") @Valid List<CreateTicketTypeRequestDto> ticketTypes) {
}