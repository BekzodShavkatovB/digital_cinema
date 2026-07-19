package com.cinema.bookingbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rowNumber;
    private int seatNum;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public Seat() {}

    public Seat(Long id, int rowNumber, int seatNum, Hall hall) {
        this.id = id;
        this.rowNumber = rowNumber;
        this.seatNum = seatNum;
        this.hall = hall;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getRowNumber() { return rowNumber; }
    public void setRowNumber(int rowNumber) { this.rowNumber = rowNumber; }

    public int getSeatNum() { return seatNum; }
    public void setSeatNum(int seatNum) { this.seatNum = seatNum; }

    public Hall getHall() { return hall; }
    public void setHall(Hall hall) { this.hall = hall; }
}