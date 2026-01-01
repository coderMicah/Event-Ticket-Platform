package com.micah.tickets.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.micah.tickets.domain.CreateEventRequest;
import com.micah.tickets.domain.CreateTicketTypeRequest;
import com.micah.tickets.domain.UpdateEventRequest;
import com.micah.tickets.domain.UpdateTicketTypeRequest;
import com.micah.tickets.domain.dtos.CreateEventRequestDto;
import com.micah.tickets.domain.dtos.CreateEventResponseDto;
import com.micah.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.micah.tickets.domain.dtos.GetEventDetailsResponseDto;
import com.micah.tickets.domain.dtos.GetEventDetailsTicketTypeResponseDto;
import com.micah.tickets.domain.dtos.ListEventResponseDto;
import com.micah.tickets.domain.dtos.ListEventTicketTypeResponseDto;
import com.micah.tickets.domain.dtos.UpdateEventRequestDto;
import com.micah.tickets.domain.dtos.UpdateEventResponseDto;
import com.micah.tickets.domain.dtos.UpdateTicketTypeRequestDto;
import com.micah.tickets.domain.dtos.UpdateTicketTypeResponseDto;
import com.micah.tickets.domain.entities.Event;
import com.micah.tickets.domain.entities.TicketType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

    GetEventDetailsTicketTypeResponseDto toGetEventDetailsTicketTypeResponseDto(TicketType ticketType);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

    UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

    UpdateEventRequest fromDto(UpdateEventRequestDto dto);

    UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

    UpdateEventResponseDto toUpdateEventResponseDto(Event event);

}
