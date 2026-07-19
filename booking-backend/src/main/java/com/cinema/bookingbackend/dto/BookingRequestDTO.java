package com.cinema.bookingbackend.dto;

public class BookingRequestDTO {
    private Long sessionId;
    private Long seatId;
    private String customerName;

    public BookingRequestDTO() {}

    public BookingRequestDTO(Long sessionId, Long seatId, String customerName) {
        this.sessionId = sessionId;
        this.seatId = seatId;
        this.customerName = customerName;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}