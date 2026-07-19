package com.cinema.bookingbackend.dto;

import java.time.LocalDateTime;

public class SessionRequestDTO {
    private Long movieId;
    private Long hallId;
    private LocalDateTime startTime;

    public SessionRequestDTO() {}

    public SessionRequestDTO(Long movieId, Long hallId, LocalDateTime startTime) {
        this.movieId = movieId;
        this.hallId = hallId;
        this.startTime = startTime;
    }

    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public Long getHallId() { return hallId; }
    public void setHallId(Long hallId) { this.hallId = hallId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
}