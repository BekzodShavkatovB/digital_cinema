package com.cinema.bookingbackend.service.impl;

import com.cinema.bookingbackend.entity.Movie;
import com.cinema.bookingbackend.exception.ResourceNotFoundException;
import com.cinema.bookingbackend.repository.MovieRepository;
import com.cinema.bookingbackend.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Фильм не найден с id: " + id));
    }
}