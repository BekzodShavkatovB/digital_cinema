package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Movie;

public interface MovieService {
    Movie saveMovie(Movie movie);
    Movie getMovieById(Long id);
}