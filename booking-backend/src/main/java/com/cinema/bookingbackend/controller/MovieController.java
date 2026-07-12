package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.dto.MovieRequestDTO;
import com.cinema.bookingbackend.dto.MovieResponseDTO;
import com.cinema.bookingbackend.entity.Movie;
import com.cinema.bookingbackend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponseDTO> createMovie(@RequestBody MovieRequestDTO request) {
        Movie movie = Movie.builder()
                .title(request.getTitle())
                .duration(request.getDuration())
                .build();

        Movie savedMovie = movieService.saveMovie(movie);

        MovieResponseDTO response = MovieResponseDTO.builder()
                .id(savedMovie.getId())
                .title(savedMovie.getTitle())
                .duration(savedMovie.getDuration())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);

        MovieResponseDTO response = MovieResponseDTO.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .duration(movie.getDuration())
                .build();

        return ResponseEntity.ok(response);
    }
}