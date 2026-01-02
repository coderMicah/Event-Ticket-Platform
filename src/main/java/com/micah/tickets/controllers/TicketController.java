package com.micah.tickets.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micah.tickets.domain.dtos.GetTicketResponseDto;
import com.micah.tickets.domain.dtos.ListTicketResponseDto;
import com.micah.tickets.mappers.TicketMapper;
import com.micah.tickets.services.TicketService;
import static com.micah.tickets.util.JwtUtil.parseUserId;

import java.util.UUID;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @GetMapping
    public ResponseEntity<Page<ListTicketResponseDto>> listTickets(
            @AuthenticationPrincipal Jwt jwt,
            Pageable pageable) {
        UUID userId = parseUserId(jwt);

        Page<ListTicketResponseDto> tickets = ticketService
                .listTicketsForUser(userId, pageable)
                .map(ticketMapper::toListTicketResponseDto);

        return ResponseEntity.ok(tickets);
    }

    @GetMapping(path = "/{ticketId}")
    public ResponseEntity<GetTicketResponseDto> getTicket(
            @AuthenticationPrincipal Jwt jwt,
            @PathVariable UUID ticketId) {
        UUID userId = parseUserId(jwt);

        return ticketService.getTicketForUser(userId, ticketId)
                .map(ticketMapper::toGetTicketResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

}
