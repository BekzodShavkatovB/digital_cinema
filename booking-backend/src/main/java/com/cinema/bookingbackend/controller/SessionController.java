package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.dto.SessionRequestDTO;
import com.cinema.bookingbackend.entity.Hall;
import com.cinema.bookingbackend.entity.Movie;
import com.cinema.bookingbackend.entity.Session;
import com.cinema.bookingbackend.service.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<Session> scheduleSession(@RequestBody SessionRequestDTO request) {
        Movie movie = new Movie();
        movie.setId(request.getMovieId());

        Hall hall = new Hall();
        hall.setId(request.getHallId());

        Session session = new Session(null, request.getStartTime(), movie, hall);

        Session savedSession = sessionService.scheduleSession(session);
        return new ResponseEntity<>(savedSession, HttpStatus.CREATED);
    }
}