package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.entity.Cinema;
import com.cinema.bookingbackend.service.CinemaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    public List<Cinema> getAllCinemas() {
        return cinemaService.findAll();
    }
}