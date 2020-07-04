package com.balanced.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerProfileDTO {
    private String playerName;
    private Integer playerStamina;
    private Integer playerPace;
    private Integer playerDribbling;
    private Integer playerVision;
    private Integer playerFirstTouch;
    private Integer playerPass;
    private Integer playerDefence;
    private Integer playerMiddle;
    private Integer playerAttack;
}
