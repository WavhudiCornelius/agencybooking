package com.example.agencybooking.hotel.dto;

import com.example.agencybooking.hotel.model.HotelContactDetails;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class HotelDto {
    private String name;
    private HotelContactDetails hotelContactDetails;
    private String address;
    private int rating;
    private String userOfEntry;
}
