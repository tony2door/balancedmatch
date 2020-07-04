package com.balanced.Entities;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users_db")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
  //  @Column(name = "player_id") // FK to player_profile
  //  private Integer playerId;
  //  @Column(name = "group_id") // FK to groups_db
  //  private Integer groupId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    GroupsOfUsers groupOfUsers;

    @OneToOne
    @JoinColumn(name = "player_id")
    PlayerProfile playerProfile;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", playerProfile=" + playerProfile.getPlayerId() +
                '}';
    }
}
