package com.example.agencybooking.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.agencybooking.guest.model.Guest;


public interface GuestRepository extends JpaRepository<Guest, Long> {

    @Query(value = "SELECT * FROM guest WHERE guest.email = :email", nativeQuery = true)
    Guest findGuestByEmail(String email);
}
