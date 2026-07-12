package com.cinema.bookingbackend.repository;

import com.cinema.bookingbackend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    // Добавь эту строчку:
    List<Seat> findByHallId(Long hallId);
}