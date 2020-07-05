package com.balanced.DTOs;

import com.balanced.Entities.GroupOfUsers;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsersDTO {
    private String userName;
    private String userPassword;
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
