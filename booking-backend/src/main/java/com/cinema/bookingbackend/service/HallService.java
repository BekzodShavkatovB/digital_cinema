package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Hall;
import java.util.List;

public interface HallService {
    List<Hall> findAll();
    Hall save(Hall hall);
}