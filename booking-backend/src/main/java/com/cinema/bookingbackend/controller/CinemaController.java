package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.entity.Cinema;
import com.cinema.bookingbackend.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
@RequiredArgsConstructor
public class CinemaController {
    private final CinemaService cinemaService;

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaService.findAll();
    }
}