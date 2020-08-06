package com.balanced.Entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_db")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "player_stamina")
    private Integer playerStamina;
    @Column(name = "player_pace")
    private Integer playerPace;
    @Column(name = "player_dribbling")
    private Integer playerDribbling;
    @Column(name = "player_vision")
    private Integer playerVision;
    @Column(name = "player_first_touch")
    private Integer playerFirstTouch;
    @Column(name = "player_pass")
    private Integer playerPass;
    @Column(name = "player_defence")
    private Integer playerDefence;
    @Column(name = "player_middle")
    private Integer playerMiddle;
    @Column(name = "player_attack")
    private Integer playerAttack;
    @Column(name = "player_role")
    @Enumerated(EnumType.STRING)
    private RoleEnum playerRole;
    @Column(name = "player_average")
    private Double playerAverage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(userId, users.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    GroupOfUsers groupOfUsersForeign;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Teams teamsForeign;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", playerStamina=" + playerStamina +
                ", playerPace=" + playerPace +
                ", playerDribbling=" + playerDribbling +
                ", playerVision=" + playerVision +
                ", playerFirstTouch=" + playerFirstTouch +
                ", playerPass=" + playerPass +
                ", playerDefence=" + playerDefence +
                ", playerMiddle=" + playerMiddle +
                ", playerAttack=" + playerAttack +
                ", playerRole=" + playerRole +
                ", playerAverage=" + playerAverage +
                ", groupOfUsersForeign=" + groupOfUsersForeign.getGroupName() +
                ", teamsForeign=" + teamsForeign.getTeamName() +
                '}';
    }
}
