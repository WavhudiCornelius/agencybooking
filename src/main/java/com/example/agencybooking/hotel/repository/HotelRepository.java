package com.example.agencybooking.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.agencybooking.hotel.model.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(value = "SELECT * FROM hotel WHERE hotel.email = :email", nativeQuery = true)
    Hotel findHotelByEmail(String email);
}
