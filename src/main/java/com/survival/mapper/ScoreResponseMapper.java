package com.survival.mapper;

import com.survival.dto.ScoreResponse;
import com.survival.dto.ScoreResponseList;
import com.survival.entity.Score;
import java.util.List;

public interface ScoreResponseMapper {

    static ScoreResponseList from(List<Score> scores){
        return ScoreResponseList.builder()
            .items(scores.stream()
                .map(score -> ScoreResponseMapper.from(score.getPlayerId(), score.getScore()))
                .toList())
            .build();
    }

    static ScoreResponse from(String name, int score){
        return ScoreResponse.builder()
            .name(name)
            .score(score)
            .build();
    }

}
