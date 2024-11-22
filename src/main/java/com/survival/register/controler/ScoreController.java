package com.survival.register.controler;

import com.survival.register.dto.ScoreResponse;
import com.survival.register.dto.ScoreResponseList;
import com.survival.register.mapper.ScoreResponseMapper;
import com.survival.register.request.ScoreRequest;
import com.survival.register.service.ScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/scores")
@Slf4j
@Tag(name = "Scores controller")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/players/{playerId}")
    @Operation(summary = "get scores from player")
    @SneakyThrows
    public Mono<ResponseEntity<ScoreResponseList>> findScoreByPlayerId(
        @PathVariable final @NotBlank String playerId
    ) {
        return scoreService.getScoreByPlayerId(playerId)
            .map(scores -> ResponseEntity.ok(ScoreResponseMapper.from(scores)));
    }

    @GetMapping("/best")
    @Operation(summary = "get scores from player")
    @SneakyThrows
    public Mono<ResponseEntity<ScoreResponseList>> findBestScores(
        @RequestParam(required = false) Integer limit
    ) {
        return scoreService.findBestScores(limit)
            .map(scores -> ResponseEntity.ok(ScoreResponseMapper.from(scores)));
    }

    @PostMapping
    @Operation(summary = "record score from a player")
    @SneakyThrows
    public Mono<ResponseEntity<ScoreResponse>> saveScore(
        @RequestBody ScoreRequest request
    ) {
        return scoreService.saveScore(request)
            .map(score -> ResponseEntity.status(HttpStatus.CREATED)
                .body(ScoreResponseMapper.from(score.getPlayerId(), score.getScore())));
    }

}
