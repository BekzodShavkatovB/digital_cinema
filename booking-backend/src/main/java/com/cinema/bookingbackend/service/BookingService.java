package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Booking;
import com.cinema.bookingbackend.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        // Здесь можно добавить логику проверки:
        // не занято ли место, существует ли сеанс и т.д.
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}