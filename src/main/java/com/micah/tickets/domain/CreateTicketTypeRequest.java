package com.micah.tickets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketTypeRequest {
    private String name;
    private Integer totalAvailable;
    private Double price;
    private String description;
}
