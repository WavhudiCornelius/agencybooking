package com.example.agencybooking.booking.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.agencybooking.booking.dto.BookingDto;
import com.example.agencybooking.booking.model.Booking;
import com.example.agencybooking.booking.service.BookingService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component
@Path("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Booking> getAllBookings(@QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("3") int size) {
        return bookingService.getAllBookings(page, size);
    }

    @GET
    @Path("/{bookingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooking(@PathParam("bookingId") Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return Response.ok(booking).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBooking(@Valid BookingDto bookingDto) {
        return Response.ok(bookingService.addBooking(bookingDto)).build();
    }

    @PUT
    @Path("/{bookingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBooking(@PathParam("bookingId") Long bookingId,@Valid BookingDto bookingDto) {
        return Response.ok(bookingService.updateBooking(bookingId, bookingDto)).build();
    }

    @DELETE
    @Path("/{bookingId}")
    public void deleteBooking(@PathParam("bookingId") Long bookingId) {
        bookingService.deleteBooking(bookingId);
    }

}
