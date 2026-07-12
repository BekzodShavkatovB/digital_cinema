package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.dto.BookingRequestDTO;
import com.cinema.bookingbackend.dto.BookingResponseDTO;
import com.cinema.bookingbackend.entity.Booking;
import com.cinema.bookingbackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO request) {
        Booking booking = bookingService.createBooking(request.getSessionId(), request.getSeatId());

        BookingResponseDTO response = BookingResponseDTO.builder()
                .id(booking.getId())
                .sessionId(booking.getSession().getId())
                .seatId(booking.getSeat().getId())
                .status("CONFIRMED")
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}