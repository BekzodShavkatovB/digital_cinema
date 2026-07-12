package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.repository.HallRepository;
import com.cinema.bookingbackend.service.impl.HallServiceImpl;
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
class HallServiceTest {

    @Mock
    private HallRepository hallRepository;

    @InjectMocks
    private HallServiceImpl hallService;

    @Test
    @DisplayName("Успешное получение списка всех залов")
    void findAll_Success() {
        when(hallRepository.findAll()).thenReturn(List.of(new Hall(), new Hall()));

        List<Hall> result = hallService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(hallRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Успешное сохранение зала")
    void save_Success() {
        Hall hall = new Hall();
        when(hallRepository.save(hall)).thenReturn(hall);

        Hall result = hallService.save(hall);

        assertNotNull(result);
        verify(hallRepository, times(1)).save(hall);
    }
}