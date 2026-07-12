package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.dto.SessionRequestDTO;
import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.entity.Movie;
import com.cinema.bookingbackend.entity.Session;
import com.cinema.bookingbackend.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<Session> scheduleSession(@RequestBody SessionRequestDTO request) {
        Session session = Session.builder()
                .movie(Movie.builder().id(request.getMovieId()).build())
                .hall(Hall.builder().id(request.getHallId()).build())
                .startTime(request.getStartTime())
                .build();

        Session savedSession = sessionService.scheduleSession(session);
        return new ResponseEntity<>(savedSession, HttpStatus.CREATED);
    }
}