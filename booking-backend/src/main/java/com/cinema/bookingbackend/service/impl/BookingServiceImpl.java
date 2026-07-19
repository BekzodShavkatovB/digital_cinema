package com.cinema.bookingbackend.service.impl;

import com.cinema.bookingbackend.entity.Booking;
import com.cinema.bookingbackend.entity.Session;
import com.cinema.bookingbackend.entity.Seat;
import com.cinema.bookingbackend.exception.SeatAlreadyBookedException;
import com.cinema.bookingbackend.exception.ResourceNotFoundException;
import com.cinema.bookingbackend.repository.BookingRepository;
import com.cinema.bookingbackend.repository.SessionRepository;
import com.cinema.bookingbackend.repository.SeatRepository;
import com.cinema.bookingbackend.service.BookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final SessionRepository sessionRepository;
    private final SeatRepository seatRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              SessionRepository sessionRepository,
                              SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.sessionRepository = sessionRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    @Transactional
    public Booking createBooking(Long sessionId, Long seatId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new ResourceNotFoundException("Сеанс не найден с id: " + sessionId));

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new ResourceNotFoundException("Место не найдено с id: " + seatId));

        boolean isOccupied = bookingRepository.existsBySessionIdAndSeatId(sessionId, seatId);
        if (isOccupied) {
            throw new SeatAlreadyBookedException("Место " + seat.getSeatNum() + " на этот сеанс уже забронировано!");
        }

        Booking booking = new Booking(null, null, session, seat);

        return bookingRepository.save(booking);
    }
}