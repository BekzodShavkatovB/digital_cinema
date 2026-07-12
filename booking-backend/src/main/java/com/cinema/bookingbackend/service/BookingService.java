package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Booking;

public interface BookingService {
    Booking createBooking(Long sessionId, Long seatId);
}