package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Seat;
import java.util.List;

public interface SeatService {
    List<Seat> findByHallId(Long hallId);
    Seat save(Seat seat);
}