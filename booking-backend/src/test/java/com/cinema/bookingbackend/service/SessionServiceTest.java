package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.entity.Movie;
import com.cinema.bookingbackend.entity.Session;
import com.cinema.bookingbackend.exception.InvalidSessionTimeException;
import com.cinema.bookingbackend.repository.SessionRepository;
import com.cinema.bookingbackend.service.impl.SessionServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SessionServiceTest {

    @Mock
    private SessionRepository sessionRepository;

    @InjectMocks
    private SessionServiceImpl sessionService;

    @Test
    @DisplayName("Успешное добавление сеанса, если зал свободен")
    void scheduleSession_Success() {
        Movie movie = new Movie(1L, "Inception", 120);
        Hall hall = new Hall(1L, "Main Hall", 100, null);
        LocalDateTime startTime = LocalDateTime.of(2026, 7, 20, 18, 0);

        Session newSession = new Session(null, startTime, movie, hall);

        when(sessionRepository.findOverlappingSessions(anyLong(), any(), any()))
                .thenReturn(Collections.emptyList());
        when(sessionRepository.save(newSession)).thenReturn(newSession);

        Session result = sessionService.scheduleSession(newSession);

        assertNotNull(result);
        verify(sessionRepository, times(1)).save(newSession);
    }

    @Test
    @DisplayName("Ошибка добавления сеанса: Время пересекается с существующим сеансом")
    void scheduleSession_ThrowsInvalidSessionTimeException() {
        Movie movie = new Movie(1L, "Inception", 120);
        Hall hall = new Hall(1L, "Main Hall", 100, null);
        LocalDateTime startTime = LocalDateTime.of(2026, 7, 20, 18, 0);

        Session newSession = new Session(null, startTime, movie, hall);

        when(sessionRepository.findOverlappingSessions(anyLong(), any(), any()))
                .thenReturn(List.of(new Session()));

        assertThrows(InvalidSessionTimeException.class, () -> {
            sessionService.scheduleSession(newSession);
        });

        verify(sessionRepository, never()).save(any());
    }
}