package com.micah.tickets.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ticket_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TicketType {
    
    @Id
    @Column(name="id",nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;
    

    @Column(name="name",nullable = false)
    @EqualsAndHashCode.Include
    private String name;

    @Column(name="total_available")
    @EqualsAndHashCode.Include
    private Integer totalAvailable;

    @Column(name="price",nullable = false)
     @EqualsAndHashCode.Include
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "ticketType",cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    @CreatedDate
    @Column(name="created_at",nullable = false,updatable = false)
    @EqualsAndHashCode.Include
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at",nullable = false,updatable = false)
    @EqualsAndHashCode.Include
    private LocalDateTime updatedAt;


}
