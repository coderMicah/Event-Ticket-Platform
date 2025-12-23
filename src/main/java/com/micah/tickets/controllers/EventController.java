package com.micah.tickets.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micah.tickets.domain.CreateEventRequest;
import com.micah.tickets.domain.dtos.CreateEventRequestDto;
import com.micah.tickets.domain.dtos.CreateEventResponseDto;
import com.micah.tickets.domain.entities.Event;
import com.micah.tickets.mappers.EventMapper;
import com.micah.tickets.services.EventService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(params = "/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @PostMapping
    public ResponseEntity<CreateEventResponseDto> createEvent(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateEventRequestDto requestDto) {

        UUID userId = UUID.fromString(jwt.getSubject());
        CreateEventRequest request = eventMapper.fromDto(requestDto);
        Event createdEvent = eventService.createEvent(userId, request);
        CreateEventResponseDto createdEventResponseDto = eventMapper.toDto(createdEvent);
        return new ResponseEntity<>(createdEventResponseDto, HttpStatus.CREATED);

    }
}
