package com.example.agencybooking.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.agencybooking.guest.controller.GuestController;
import com.example.agencybooking.hotel.controller.HotelController;


@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(GuestController.class);
        register(HotelController.class);
    }
}
