package com.survival.register.repository;

import com.survival.register.entity.Score;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ScoreRepository extends ReactiveMongoRepository<Score, String> {

    Flux<Score> findByPlayerId(String playerId);
}
