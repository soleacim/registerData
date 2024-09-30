package com.survival.controler;

import com.survival.dto.ScoreResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping("/{playerId}")
    @SneakyThrows
    public Mono<ResponseEntity<ScoreResponse>> findScoreById(
        @PathVariable final @NotBlank String playerId) {
        return Mono.just(ResponseEntity.ok(ScoreResponseMapper.from(playerId, 0)));
    }

}
