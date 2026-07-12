package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Booking;
import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.entity.Movie;
import com.cinema.bookingbackend.entity.Seat;
import com.cinema.bookingbackend.entity.Session;
import com.cinema.bookingbackend.exception.ResourceNotFoundException;
import com.cinema.bookingbackend.exception.SeatAlreadyBookedException;
import com.cinema.bookingbackend.repository.BookingRepository;
import com.cinema.bookingbackend.repository.SeatRepository;
import com.cinema.bookingbackend.repository.SessionRepository;
import com.cinema.bookingbackend.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;
    @Mock
    private SessionRepository sessionRepository;
    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    @DisplayName("Успешное бронирование, если место свободно")
    void createBooking_Success() {
        Long sessionId = 1L;
        Long seatId = 1L;

        Session mockSession = Session.builder()
                .id(sessionId)
                .movie(new Movie())
                .hall(new Hall())
                .startTime(LocalDateTime.now())
                .build();

        Seat mockSeat = Seat.builder()
                .id(seatId)
                .rowNumber(1)
                .seatNum(10)
                .hall(new Hall())
                .build();        Booking mockSavedBooking = Booking.builder().id(100L).session(mockSession).seat(mockSeat).build();

        when(sessionRepository.findById(sessionId)).thenReturn(Optional.of(mockSession));
        when(seatRepository.findById(seatId)).thenReturn(Optional.of(mockSeat));
        when(bookingRepository.existsBySessionIdAndSeatId(sessionId, seatId)).thenReturn(false);
        when(bookingRepository.save(any(Booking.class))).thenReturn(mockSavedBooking);

        Booking result = bookingService.createBooking(sessionId, seatId);

        assertNotNull(result);
        assertEquals(100L, result.getId());
        assertEquals(sessionId, result.getSession().getId());
        assertEquals(seatId, result.getSeat().getId());

        verify(sessionRepository, times(1)).findById(sessionId);
        verify(seatRepository, times(1)).findById(seatId);
        verify(bookingRepository, times(1)).existsBySessionIdAndSeatId(sessionId, seatId);
        verify(bookingRepository, times(1)).save(any(Booking.class));
    }

    @Test
    @DisplayName("Ошибка бронирования: Место уже занято")
    void createBooking_ThrowsSeatAlreadyBookedException() {
        Long sessionId = 1L;
        Long seatId = 1L;

        Session mockSession = Session.builder()
                .id(sessionId)
                .movie(new Movie())
                .hall(new Hall())
                .startTime(LocalDateTime.now())
                .build();

        Seat mockSeat = Seat.builder()
                .id(seatId)
                .rowNumber(1)
                .seatNum(10)
                .hall(new Hall())
                .build();
        when(sessionRepository.findById(sessionId)).thenReturn(Optional.of(mockSession));
        when(seatRepository.findById(seatId)).thenReturn(Optional.of(mockSeat));
        when(bookingRepository.existsBySessionIdAndSeatId(sessionId, seatId)).thenReturn(true);

        assertThrows(SeatAlreadyBookedException.class, () -> {
            bookingService.createBooking(sessionId, seatId);
        });

        verify(bookingRepository, never()).save(any(Booking.class));
    }

    @Test
    @DisplayName("Ошибка бронирования: Сеанс не найден")
    void createBooking_ThrowsResourceNotFoundException_WhenSessionNotFound() {
        Long sessionId = 999L;
        Long seatId = 1L;

        when(sessionRepository.findById(sessionId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            bookingService.createBooking(sessionId, seatId);
        });

        verify(seatRepository, never()).findById(anyLong());
        verify(bookingRepository, never()).save(any(Booking.class));
    }
}