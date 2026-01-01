package com.micah.tickets.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.micah.tickets.domain.CreateEventRequest;
import com.micah.tickets.domain.UpdateEventRequest;
import com.micah.tickets.domain.entities.Event;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);

    Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);

    Optional<Event> getEventForOrganizer(UUID organizerId, UUID eventId);

    Event updateEventForOrganizer(UUID organizerId, UUID eventId, UpdateEventRequest event);

    void deleteEventForOrganizer(UUID organizerId, UUID eventId);

    Page<Event> listPublishedEvents(Pageable pageable);
}
