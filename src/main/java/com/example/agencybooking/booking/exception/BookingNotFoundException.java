package com.example.agencybooking.booking.exception;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(Long bookingId) {
        super("Could not find booking with id: " + bookingId);
    }
}
