package com.survival.repository;

import com.survival.entity.Score;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ScoreRepository extends ReactiveMongoRepository<Score, String> {

    Mono<Score> findByPlayerId(String playerId);
}
