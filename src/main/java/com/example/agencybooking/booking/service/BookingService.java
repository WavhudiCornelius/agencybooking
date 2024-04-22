package com.example.agencybooking.booking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.agencybooking.booking.dto.BookingDto;
import com.example.agencybooking.booking.exception.BookingNotFoundException;
import com.example.agencybooking.booking.model.Booking;
import com.example.agencybooking.booking.repository.BookingRepository;
import com.example.agencybooking.guest.model.Guest;
import com.example.agencybooking.guest.service.GuestService;
import com.example.agencybooking.hotel.model.Hotel;
import com.example.agencybooking.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final GuestService guestService;
    private final HotelService hotelService;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);

        if (booking.isEmpty()) {
            throw new BookingNotFoundException(bookingId);
        }
        return booking.get();
    }

    public Booking addBooking(BookingDto bookingDto) {
        Guest guest = guestService.getGuestByEmail(bookingDto.getGuestEmail());
        Hotel hotel = hotelService.getHotelByEmail(bookingDto.getHotelEmail());
        Booking booking = Booking.builder()
                .guest(guest)
                .hotel(hotel)
                .roomType(bookingDto.getRoomType())
                .rooms(bookingDto.getRooms())
                .adults(bookingDto.getAdults())
                .children(bookingDto.getChildren())
                .arrival(bookingDto.getArrival())
                .departure(bookingDto.getDeparture())
                .build();

        booking.setUserOfEntry(bookingDto.getUserOfEntryAndUpdate());
        booking.setDateOfEntry(LocalDateTime.now());
        booking.setUserOfLastUpdate(bookingDto.getUserOfEntryAndUpdate());
        booking.setDateOfLastUpdate(LocalDateTime.now());

        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long bookingId, BookingDto bookingDto) {
        Booking booking = getBookingById(bookingId);

        if(bookingDto.getRoomType() != null) {
            booking.setRoomType(bookingDto.getRoomType());
        } else if (bookingDto.getRooms() != 0) {
            booking.setRooms(booking.getRooms());
        } else if (bookingDto.getAdults() != 0) {
            booking.setAdults(booking.getAdults());
        } else if (bookingDto.getChildren() != 0) {
            booking.setChildren(bookingDto.getChildren());
        } else if (bookingDto.getArrival() != null) {
            booking.setArrival(bookingDto.getArrival());
        } else if (bookingDto.getDeparture() != null) {
            booking.setDeparture(bookingDto.getDeparture());
        }
        booking.setDateOfLastUpdate(LocalDateTime.now());
        booking.setUserOfLastUpdate(bookingDto.getUserOfEntryAndUpdate());

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long bookingId) {
        Booking booking = getBookingById(bookingId);

        bookingRepository.delete(booking);
    }

}
