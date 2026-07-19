package com.cinema.bookingbackend.controller;

import com.cinema.bookingbackend.dto.MovieRequestDTO;
import com.cinema.bookingbackend.dto.MovieResponseDTO;
import com.cinema.bookingbackend.entity.Movie;
import com.cinema.bookingbackend.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieResponseDTO> createMovie(@RequestBody MovieRequestDTO request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDuration(request.getDuration());

        Movie savedMovie = movieService.saveMovie(movie);

        MovieResponseDTO response = new MovieResponseDTO(
                savedMovie.getId(),
                savedMovie.getTitle(),
                savedMovie.getDuration()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);

        MovieResponseDTO response = new MovieResponseDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDuration()
        );

        return ResponseEntity.ok(response);
    }
}