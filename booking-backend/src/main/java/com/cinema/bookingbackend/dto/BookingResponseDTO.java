package com.cinema.bookingbackend.dto;

public class BookingResponseDTO {
    private Long id;
    private Long sessionId;
    private Long seatId;
    private String status;

    public BookingResponseDTO() {}

    public BookingResponseDTO(Long id, Long sessionId, Long seatId, String status) {
        this.id = id;
        this.sessionId = sessionId;
        this.seatId = seatId;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public Long getSeatId() { return seatId; }
    public void setSeatId(Long seatId) { this.seatId = seatId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}