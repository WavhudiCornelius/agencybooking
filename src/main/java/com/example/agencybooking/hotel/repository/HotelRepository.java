package com.example.agencybooking.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agencybooking.hotel.model.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
