package com.micah.tickets.domain.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record UpdateTicketTypeRequestDto(
                UUID id,
                @NotBlank(message = "Ticket type name is required") String name,

                @NotNull(message = "Price is required") @PositiveOrZero(message = "Price can be zero or greater") Double price,

                Integer totalAvailable,

                String description) {
}
