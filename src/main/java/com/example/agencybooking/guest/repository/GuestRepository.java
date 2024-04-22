package com.example.agencybooking.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agencybooking.guest.model.Guest;


public interface GuestRepository extends JpaRepository<Guest, Long> {

}
