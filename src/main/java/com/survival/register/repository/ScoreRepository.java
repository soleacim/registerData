package com.survival.register.repository;

import com.survival.register.entity.Score;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ScoreRepository extends ReactiveCrudRepository<User, Long> {

    Flux<Score> findByPlayerId(String playerId);
}
