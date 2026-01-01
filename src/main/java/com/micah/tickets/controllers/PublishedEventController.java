package com.micah.tickets.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micah.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.micah.tickets.domain.entities.Event;
import com.micah.tickets.mappers.EventMapper;
import com.micah.tickets.services.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/published-events")
@RequiredArgsConstructor
public class PublishedEventController {

    private final EventService eventService;
    private final EventMapper mapper;

    @GetMapping
    public ResponseEntity<List<ListPublishedEventResponseDto>> getPublishedEvents(
            @RequestParam(required = false) String query,
            @AuthenticationPrincipal Jwt jwt,
            Pageable pageable) {

        Page<Event> events;
        if (query != null && !query.trim().isEmpty()) {
            events = eventService.searchPublishedEvents(query, pageable);
        } else {
            events = eventService.listPublishedEvents(pageable);
        }

        List<ListPublishedEventResponseDto> publishedEvents = events
                .map(mapper::toListPublishedEventResponseDto).toList();

        return ResponseEntity.ok(publishedEvents);
    }

}
