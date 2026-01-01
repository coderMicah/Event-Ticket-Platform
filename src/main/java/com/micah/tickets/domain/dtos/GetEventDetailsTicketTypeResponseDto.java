package com.micah.tickets.domain.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetEventDetailsTicketTypeResponseDto(
                UUID id,
                String name,
                Double price,
                Integer totalAvailable,
                String description,
                LocalDateTime createdAt,
                LocalDateTime updatedAt) {

}
