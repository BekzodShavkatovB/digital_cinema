package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.service.HallService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/halls")
public class HallController {

    private final HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping
    public List<Hall> getAllHalls() {
        return hallService.findAll();
    }
}