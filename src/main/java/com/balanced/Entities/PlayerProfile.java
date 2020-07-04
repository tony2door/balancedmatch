package com.balanced.Entities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "player_profile_db")
@Getter
@Setter
@ToString

public class PlayerProfile {

    @Id
    @GeneratedValue

    @Column(name = "player_id")
    private Integer playerId;
    @Column(name = "player_name")
    private String playerName;
    @Column(name = "player_stamina")
    private Integer playerStamina;
    @Column(name = "player_pace")
    private Integer playerPace;
    @Column(name = "player_dribbling")
    private Integer playerDribbling;
    @Column(name = "player_vision")
    private Integer playerVision;
    @Column(name = "player_first_touch")
    private   Integer playerFirstTouch;
    @Column(name = "player_pass")
    private Integer playerPass;
    @Column(name = "player_defence")
    private Integer playerDefence;
    @Column(name = "player_middle")
    private Integer playerMiddle;
    @Column(name = "player_attack")
    private Integer playerAttack;

    @OneToOne(mappedBy = "playerProfile")
    Users user;

}
