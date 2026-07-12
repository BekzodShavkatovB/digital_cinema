package com.cinema.bookingbackend.service.impl;

import com.cinema.bookingbackend.entity.Cinema;
import com.cinema.bookingbackend.repository.CinemaRepository;
import com.cinema.bookingbackend.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    @Override
    @Transactional
    public Cinema save(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }
}