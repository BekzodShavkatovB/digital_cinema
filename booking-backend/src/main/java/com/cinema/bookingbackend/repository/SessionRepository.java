package com.cinema.bookingbackend.repository;

import com.cinema.bookingbackend.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT s FROM Session s WHERE s.hall.id = :hallId " +
            "AND ((s.startTime < :endTime AND s.startTime >= :startTime) " +
            "OR (s.startTime <= :startTime AND s.startTime > :startTime))")
    List<Session> findOverlappingSessions(@Param("hallId") Long hallId,
                                          @Param("startTime") LocalDateTime startTime,
                                          @Param("endTime") LocalDateTime endTime);
}