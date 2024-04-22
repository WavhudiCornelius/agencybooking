package com.example.agencybooking.hotel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.agencybooking.hotel.dto.HotelDto;
import com.example.agencybooking.hotel.model.Hotel;
import com.example.agencybooking.hotel.repository.HotelRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    //TODO: add Hotel, update hotel, delete hotel, get all get 1

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel addHotel(HotelDto hotelDto) {
        Hotel hotel = Hotel.builder()
                .name(hotelDto.getName())
                .email(hotelDto.getEmail())
                .telNumber(hotelDto.getTelNumber())
                .mobileNumber(hotelDto.getMobileNumber())
                .faxNumber(hotelDto.getFaxNumber())
                .address(hotelDto.getAddress())
                .rating(hotelDto.getRating())
                .build();

        hotel.setDateOfEntry(LocalDateTime.now());
        hotel.setUserOfEntry(hotel.getUserOfEntry());
        hotel.setUserOfLastUpdate(hotel.getUserOfEntry());
        hotel.setDateOfLastUpdate(LocalDateTime.now());

        return hotelRepository.save(hotel);
    }

    public Hotel getHotelByEmail(String email) {
        return hotelRepository.findHotelByEmail(email);
    }
}
