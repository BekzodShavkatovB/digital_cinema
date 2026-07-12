package com.cinema.bookingbackend.service.impl;

import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.repository.HallRepository;
import com.cinema.bookingbackend.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Hall> findAll() {
        return hallRepository.findAll();
    }

    @Override
    @Transactional
    public Hall save(Hall hall) {
        return hallRepository.save(hall);
    }
}