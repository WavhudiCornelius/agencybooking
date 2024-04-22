package com.example.agencybooking.booking.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.agencybooking.booking.dto.BookingDto;
import com.example.agencybooking.booking.exception.BookingNotFoundException;
import com.example.agencybooking.booking.model.Booking;
import com.example.agencybooking.booking.repository.BookingRepository;
import com.example.agencybooking.guest.model.Guest;
import com.example.agencybooking.guest.service.GuestService;
import com.example.agencybooking.hotel.model.Hotel;
import com.example.agencybooking.hotel.service.HotelService;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
    @InjectMocks
    private BookingService bookingService;

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private GuestService guestService;

    @Mock
    private HotelService hotelService;

    @Test
    public void getBookingById_BookingFound_ReturnsBooking() {
        // Arrange
        Long bookingId = 1L;
        Booking booking = createBooking(bookingId);
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Act
        Booking result = bookingService.getBookingById(bookingId);

        // Assert
        assertEquals(result, booking);
    }


    @Test
    public void getBookingById_BookingNotFound_ThrowsException() {
        // Arrange
        Long bookingId = 1L;
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BookingNotFoundException.class, () -> bookingService.getBookingById(bookingId));
    }

    @Test
    public void addBooking_ValidBookingDto_SavesAndReturnsBooking() {
        // Arrange
        BookingDto bookingDto = createBookingDto();
        Guest guest = createGuest();
        Hotel hotel = createHotel();

        when(guestService.getGuestByEmail(bookingDto.getGuestEmail())).thenReturn(guest);
        when(hotelService.getHotelByEmail(bookingDto.getHotelEmail())).thenReturn(hotel);

        Booking savedBooking = createBooking(1L);
        when(bookingRepository.save(any(Booking.class))).thenReturn(savedBooking);

        // Act
        Booking result = bookingService.addBooking(bookingDto);

        // Assert
        assertThat(result).isSameAs(savedBooking);
    }

    private BookingDto createBookingDto() {
        return new BookingDto();
    }

    private Hotel createHotel() {
        return Hotel.builder().build();
    }

    private Guest createGuest() {
        return Guest.builder().build();
    }

    private Booking createBooking(Long bookingId) {
        return Booking.builder()
                .id(bookingId)
                .build();
    }
}