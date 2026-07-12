package com.cinema.bookingbackend.service.impl;

import com.cinema.bookingbackend.entity.Seat;
import com.cinema.bookingbackend.repository.SeatRepository;
import com.cinema.bookingbackend.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Seat> findByHallId(Long hallId) {
        return seatRepository.findByHallId(hallId);
    }

    @Override
    @Transactional
    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }
}