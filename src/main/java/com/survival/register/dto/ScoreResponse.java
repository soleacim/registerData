package com.survival.register.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ScoreResponse {

    private String name;
    private int score;

}
