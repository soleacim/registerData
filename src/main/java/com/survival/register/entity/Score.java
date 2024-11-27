package com.survival.register.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "scores")
public class Score {

    @Id
    private Long id;

    private String playerId;

    private int score;
}
