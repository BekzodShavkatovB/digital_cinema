package com.cinema.bookingbackend.dto;

public class MovieRequestDTO {
    private String title;
    private Integer duration;

    public MovieRequestDTO() {}

    public MovieRequestDTO(String title, Integer duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
}