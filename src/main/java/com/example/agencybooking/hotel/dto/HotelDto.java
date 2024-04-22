package com.example.agencybooking.hotel.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class HotelDto {
    private String name;
    private String email;
    private String telNumber;
    private String mobileNumber;
    private String faxNumber;
    private String address;
    private int rating;
    private String userOfEntry;
}
