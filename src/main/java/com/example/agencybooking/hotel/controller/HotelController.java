package com.example.agencybooking.hotel.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.agencybooking.hotel.dto.HotelDto;
import com.example.agencybooking.hotel.model.Hotel;
import com.example.agencybooking.hotel.service.HotelService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
@Path("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addHotel(HotelDto hotelDto) {
        return Response.ok(hotelService.addHotel(hotelDto)).build();
    }

    @GET
    @Path("/hotel")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getHotel(@QueryParam("email") String email) {
        Hotel hotel = hotelService.getHotelByEmail(email);

        return hotel != null ? Response.ok(hotel).build() : Response.status(404, "Hotel of email [" + email + "] not found.").build();
    }
}
