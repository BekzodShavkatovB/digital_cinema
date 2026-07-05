package com.cinema.bookingbackend.service;

import com.cinema.bookingbackend.entity.Session;
import com.cinema.bookingbackend.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    // Можно добавить метод поиска сеансов по конкретному фильму
    public List<Session> findByMovieId(Long movieId) {
        return sessionRepository.findAll().stream()
                .filter(s -> s.getMovie().getId().equals(movieId))
                .toList();
    }
}