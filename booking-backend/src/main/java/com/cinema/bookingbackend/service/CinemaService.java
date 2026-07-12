package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Cinema;
import java.util.List;

public interface CinemaService {
    List<Cinema> findAll();
    Cinema save(Cinema cinema);
}