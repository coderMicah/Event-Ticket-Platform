package com.micah.tickets.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTicketTypeRequest {
    private UUID id;
    private String name;
    private Integer totalAvailable;
    private Double price;
    private String description;
}
