package com.example.agencybooking.booking.service;

import org.springframework.stereotype.Service;

import com.example.agencybooking.booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    //TODO: add Hotel, update hotel, delete hotel, get all get 1
}
