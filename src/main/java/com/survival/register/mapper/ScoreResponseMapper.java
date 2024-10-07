package com.survival.register.mapper;

import com.survival.register.dto.ScoreResponse;
import com.survival.register.dto.ScoreResponseList;
import com.survival.register.entity.Score;
import java.util.List;
import org.springframework.util.CollectionUtils;

public interface ScoreResponseMapper {

    static ScoreResponseList from(List<Score> scores){
        if(CollectionUtils.isEmpty(scores)){
            return null;
        }
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
