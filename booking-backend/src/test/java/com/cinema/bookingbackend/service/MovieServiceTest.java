package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Movie;
import com.cinema.bookingbackend.exception.ResourceNotFoundException;
import com.cinema.bookingbackend.repository.MovieRepository;
import com.cinema.bookingbackend.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Test
    @DisplayName("Успешное сохранение нового фильма")
    void saveMovie_Success() {
        Movie movie = new Movie(null, "Inception", 148);
        Movie savedMovie = new Movie(1L, "Inception", 148);
        when(movieRepository.save(any(Movie.class))).thenReturn(savedMovie);

        Movie result = movieService.saveMovie(movie);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Inception", result.getTitle());
        verify(movieRepository, times(1)).save(movie);
    }

    @Test
    @DisplayName("Успешный поиск фильма по существующему ID")
    void getMovieById_Success() {
        Long movieId = 1L;
        Movie movie = new Movie(movieId, "Inception", 148);

        when(movieRepository.findById(movieId)).thenReturn(Optional.of(movie));

        Movie result = movieService.getMovieById(movieId);

        assertNotNull(result);
        assertEquals(movieId, result.getId());
        verify(movieRepository, times(1)).findById(movieId);
    }

    @Test
    @DisplayName("Ошибка поиска фильма: Фильм с таким ID не существует")
    void getMovieById_ThrowsResourceNotFoundException() {
        Long movieId = 999L;

        when(movieRepository.findById(movieId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            movieService.getMovieById(movieId);
        });

        verify(movieRepository, times(1)).findById(movieId);
    }
}