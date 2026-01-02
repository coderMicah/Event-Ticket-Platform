package com.micah.tickets.domain.dtos;

import java.util.UUID;

public record GetPublishedEventDetailsTicketTypeResponseDto(
                UUID id,
                String name,
                Double price,
                String description) {

}
