package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Cinema;
import com.cinema.bookingbackend.repository.CinemaRepository;
import com.cinema.bookingbackend.service.impl.CinemaServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CinemaServiceTest {

    @Mock
    private CinemaRepository cinemaRepository;

    @InjectMocks
    private CinemaServiceImpl cinemaService;

    @Test
    @DisplayName("Успешное получение списка всех кинотеатров")
    void findAll_Success() {
        when(cinemaRepository.findAll()).thenReturn(List.of(new Cinema(), new Cinema()));

        List<Cinema> result = cinemaService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(cinemaRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Успешное сохранение кинотеатра")
    void save_Success() {
        Cinema cinema = new Cinema();
        when(cinemaRepository.save(cinema)).thenReturn(cinema);

        Cinema result = cinemaService.save(cinema);

        assertNotNull(result);
        verify(cinemaRepository, times(1)).save(cinema);
    }
}