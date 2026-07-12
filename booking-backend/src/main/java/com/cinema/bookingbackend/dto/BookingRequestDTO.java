package com.cinema.bookingbackend.dto;

import lombok.Data;

@Data
public class BookingRequestDTO {
    private Long sessionId;
    private Long seatId;
}