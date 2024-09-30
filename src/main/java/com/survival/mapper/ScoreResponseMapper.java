package com.survival.mapper;

import com.survival.dto.ScoreResponse;

public interface ScoreResponseMapper {

    static ScoreResponse from(String name, int score){
        return ScoreResponse.builder()
            .name(name)
            .score(score)
            .build();
    }

}
