package com.survival.register.service;


import com.survival.register.entity.Score;
import com.survival.register.repository.ScoreRepository;
import com.survival.register.request.ScoreRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@AllArgsConstructor
public class ScoreService {

    private ScoreRepository scoreRepository;

    public Mono<List<Score>> getScoreByPlayerId(String playerId){
        return scoreRepository.findByPlayerId(playerId).collectList();
    }

    public Mono<Score> saveScore(ScoreRequest request){
        Score score = new Score();
        score.setPlayerId(request.getPlayerId());
        score.setScore(request.getScore());
        return scoreRepository.save(score);
    }


}
