package com.micah.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.micah.tickets.domain.dtos.ListTicketResponseDto;
import com.micah.tickets.domain.dtos.ListTicketTicketTypeResponseDto;
import com.micah.tickets.domain.entities.Ticket;
import com.micah.tickets.domain.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    ListTicketResponseDto toListTicketResponseDto(Ticket ticket);

    ListTicketTicketTypeResponseDto toListTicketTicketTypeResponseDto(TicketType ticketType);

}