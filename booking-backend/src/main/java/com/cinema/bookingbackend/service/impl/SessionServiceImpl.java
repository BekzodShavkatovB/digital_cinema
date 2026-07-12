package com.cinema.bookingbackend.service.impl;

import com.cinema.bookingbackend.entity.Session;
import com.cinema.bookingbackend.exception.InvalidSessionTimeException;
import com.cinema.bookingbackend.repository.SessionRepository;
import com.cinema.bookingbackend.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    @Override
    @Transactional
    public Session scheduleSession(Session session) {
        LocalDateTime endTime = session.getStartTime().plusMinutes(session.getMovie().getDuration());

        List<Session> overlappingSessions = sessionRepository.findOverlappingSessions(
                session.getHall().getId(),
                session.getStartTime(),
                endTime
        );

        if (!overlappingSessions.isEmpty()) {
            throw new InvalidSessionTimeException("Зал уже занят другим сеансом в это время!");
        }

        return sessionRepository.save(session);
    }
}