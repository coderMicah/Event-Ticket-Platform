package com.micah.tickets.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateTicketTypeRequestDto(
        @NotBlank(message = "Ticket type name is required") String name,

        @NotBlank(message = "Price is required") @PositiveOrZero(message = "Price can be zero or greater") Double price,

        Integer totalAvailable,

        String description) {
}
