package com.example.agencybooking.booking.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class BookingNotFoundExceptionMapper implements ExceptionMapper<BookingNotFoundException> {

    private static final Logger logger = LogManager.getLogger(BookingNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(BookingNotFoundException exception) {
        logger.info("Exception Mapper has been executed.");
        return Response.status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
