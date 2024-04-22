package com.example.agencybooking.booking.model;

import java.time.LocalDateTime;

import com.example.agencybooking.hotel.model.Hotel;
import com.example.agencybooking.guest.model.Guest;
import com.example.agencybooking.utils.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Guest guest;
    private String roomType;
    private int rooms;
    private int adults;
    private int children;
    private LocalDateTime arrival;
    private LocalDateTime departure;

}
