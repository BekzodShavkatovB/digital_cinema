package com.cinema.bookingbackend.service.impl;

import com.cinema.bookingbackend.entity.Seat;
import com.cinema.bookingbackend.repository.SeatRepository;
import com.cinema.bookingbackend.service.SeatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

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