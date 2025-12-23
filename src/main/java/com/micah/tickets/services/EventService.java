package com.micah.tickets.services;

import java.util.UUID;

import com.micah.tickets.domain.CreateEventRequest;
import com.micah.tickets.domain.entities.Event;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
