package com.cinema.bookingbackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponseDTO {
    private Long id;
    private Long sessionId;
    private Long seatId;
    private String status;
}