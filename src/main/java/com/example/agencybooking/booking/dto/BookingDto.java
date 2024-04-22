package com.example.agencybooking.booking.dto;


import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookingDto {

    private String guestEmail;
    private String hotelEmail;
    private String roomType;
    private int rooms;
    private int adults;
    private int children;
    private LocalDateTime arrival;
    private LocalDateTime departure;
    @NotBlank
    private String userOfEntryAndUpdate;
}
