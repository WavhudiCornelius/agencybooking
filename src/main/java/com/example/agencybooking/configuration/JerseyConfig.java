package com.example.agencybooking.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.example.agencybooking.booking.controller.BookingController;
import com.example.agencybooking.booking.exception.BookingNotFoundExceptionMapper;
import com.example.agencybooking.guest.controller.GuestController;
import com.example.agencybooking.hotel.controller.HotelController;


@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(GuestController.class);
        register(HotelController.class);
        register(BookingController.class);
        register(BookingNotFoundExceptionMapper.class);
    }
}
