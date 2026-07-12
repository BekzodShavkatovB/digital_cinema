package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/halls")
@RequiredArgsConstructor
public class HallController {
    private final HallService hallService;

    @GetMapping
    public List<Hall> getAllHalls() {
        return hallService.findAll();
    }
}