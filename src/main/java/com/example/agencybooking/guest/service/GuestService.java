package com.example.agencybooking.guest.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.agencybooking.guest.dto.GuestDto;
import com.example.agencybooking.guest.model.Guest;
import com.example.agencybooking.guest.repository.GuestRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    public Guest addGuest(GuestDto guestDto) {

        Guest guest = Guest.builder()
                .name(guestDto.getName())
                .surname(guestDto.getSurname())
                .email(guestDto.getEmail())
                .mobileNumber(guestDto.getMobileNumber())
                .address(guestDto.getAddress())
                .build();

        guest.setDateOfEntry(LocalDateTime.now());
        guest.setUserOfEntry(guestDto.getUserOfEntry());
        guest.setUserOfLastUpdate(guestDto.getUserOfEntry());
        guest.setDateOfLastUpdate(LocalDateTime.now());

        return guestRepository.save(guest);
    }

    public List<Guest> getAllGuest() {
        return guestRepository.findAll();
    }

    public Guest getGuestByEmail(String email) {
        return guestRepository.findGuestByEmail(email);
    }
}
