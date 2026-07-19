package com.cinema.bookingbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    public Hall() {}

    public Hall(Long id, String name, Integer capacity, Cinema cinema) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.cinema = cinema;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public Cinema getCinema() { return cinema; }
    public void setCinema(Cinema cinema) { this.cinema = cinema; }
}