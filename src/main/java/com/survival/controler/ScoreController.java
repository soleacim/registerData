package com.survival.controler;

import com.survival.dto.ScoreResponse;
import com.survival.request.ScoreRequest;
import com.survival.service.ScoreService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import jakarta.validation.constraints.NotBlank;
import com.survival.mapper.ScoreResponseMapper;

@RestController
@RequestMapping("score")
@Slf4j
@AllArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/{playerId}")
    @SneakyThrows
    public Mono<ResponseEntity<ScoreResponse>> findScoreById(@PathVariable final @NotBlank String playerId) {
        return scoreService.getScoreByPlayerId(playerId)
            .map(score -> ResponseEntity.ok(
                ScoreResponseMapper.from(score.getPlayerId(), score.getScore())));
    }

    @PostMapping
    @SneakyThrows
    public Mono<ResponseEntity<ScoreResponse>> saveScore(@RequestBody ScoreRequest request){
        return scoreService.saveScore(request)
            .map(score -> ResponseEntity.status(HttpStatus.CREATED)
                .body(ScoreResponseMapper.from(score.getPlayerId(), score.getScore())));
    }

}
