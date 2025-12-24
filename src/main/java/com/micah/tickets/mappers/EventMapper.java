package com.micah.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.micah.tickets.domain.CreateEventRequest;
import com.micah.tickets.domain.CreateTicketTypeRequest;
import com.micah.tickets.domain.dtos.CreateEventRequestDto;
import com.micah.tickets.domain.dtos.CreateEventResponseDto;
import com.micah.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.micah.tickets.domain.dtos.ListEventResponseDto;
import com.micah.tickets.domain.dtos.ListEventTicketTypeResponseDto;
import com.micah.tickets.domain.entities.Event;
import com.micah.tickets.domain.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

}
