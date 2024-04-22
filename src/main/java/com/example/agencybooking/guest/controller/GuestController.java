package com.example.agencybooking.guest.controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.agencybooking.guest.dto.GuestDto;
import com.example.agencybooking.guest.model.Guest;
import com.example.agencybooking.guest.service.GuestService;
import jakarta.transaction.Transactional;
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
@Path("/guest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GuestController {

    private final GuestService guestService;

    @GET
    @Transactional
    public List<Guest> getAllGuest() {
        return guestService.getAllGuest();
    }

    @POST
    public Response addGuest(@RequestBody GuestDto guestDto) {
        return Response.ok(guestService.addGuest(guestDto)).build();
    }

    // TODO: UPDATE, DELETE GUEST, GET ONE GUEST
}


