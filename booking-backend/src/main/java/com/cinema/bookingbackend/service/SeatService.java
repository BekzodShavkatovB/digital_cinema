package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Seat;
import com.cinema.bookingbackend.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }
}