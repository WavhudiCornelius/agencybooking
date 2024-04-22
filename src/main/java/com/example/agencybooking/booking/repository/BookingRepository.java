package com.example.agencybooking.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agencybooking.booking.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {

}
