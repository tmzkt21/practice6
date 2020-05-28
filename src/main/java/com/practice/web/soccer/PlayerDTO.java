package com.practice.web.soccer;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class PlayerDTO {
    private String playerId, playerName, ePlayerName, nickname, joinYyyy,
            position, backNo, nation, birthDate, solar,
            height, weight;
}
