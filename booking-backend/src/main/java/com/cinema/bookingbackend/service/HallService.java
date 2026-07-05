package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallRepository hallRepository;

    public List<Hall> findAll() {
        return hallRepository.findAll();
    }

    public Hall save(Hall hall) {
        return hallRepository.save(hall);
    }
}