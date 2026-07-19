package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.dto.BookingRequestDTO;
import com.cinema.bookingbackend.dto.BookingResponseDTO;
import com.cinema.bookingbackend.entity.Booking;
import com.cinema.bookingbackend.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO request) {
        Booking booking = bookingService.createBooking(request.getSessionId(), request.getSeatId());

        BookingResponseDTO response = new BookingResponseDTO(
                booking.getId(),
                booking.getSession().getId(),
                booking.getSeat().getId(),
                "CONFIRMED"
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}