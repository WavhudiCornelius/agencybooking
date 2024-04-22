package com.example.agencybooking.hotel.controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.agencybooking.hotel.dto.HotelDto;
import com.example.agencybooking.hotel.model.Hotel;
import com.example.agencybooking.hotel.service.HotelService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
@Path("/hotel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HotelController {

    private final HotelService hotelService;

    @GET
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @POST
    public Response addHotel(@RequestBody HotelDto hotelDto) {
        return Response.ok(hotelService.addHotel(hotelDto)).build();
    }
}
