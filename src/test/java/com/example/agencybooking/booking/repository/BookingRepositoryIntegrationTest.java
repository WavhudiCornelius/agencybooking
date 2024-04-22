package com.example.agencybooking.booking.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.agencybooking.booking.model.Booking;


@DataJpaTest
class BookingRepositoryIntegrationTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    @Sql("classpath:test-data.sql")
    void shouldFindBookingById() {
        Long bookingId = 1L;

        // Execute
        Optional<Booking> result = bookingRepository.findById(bookingId);

        // Assert
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(bookingId);
    }
}