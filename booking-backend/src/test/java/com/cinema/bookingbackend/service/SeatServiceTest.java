package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Seat;
import com.cinema.bookingbackend.repository.SeatRepository;
import com.cinema.bookingbackend.service.impl.SeatServiceImpl;
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
class SeatServiceTest {

    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private SeatServiceImpl seatService;

    @Test
    @DisplayName("Успешное получение мест по ID зала")
    void findByHallId_Success() {
        Long hallId = 1L;
        when(seatRepository.findByHallId(hallId)).thenReturn(List.of(new Seat()));

        List<Seat> result = seatService.findByHallId(hallId);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(seatRepository, times(1)).findByHallId(hallId);
    }

    @Test
    @DisplayName("Успешное сохранение места")
    void save_Success() {
        Seat seat = new Seat();
        when(seatRepository.save(seat)).thenReturn(seat);

        Seat result = seatService.save(seat);

        assertNotNull(result);
        verify(seatRepository, times(1)).save(seat);
    }
}