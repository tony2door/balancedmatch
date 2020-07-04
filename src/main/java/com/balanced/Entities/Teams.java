package com.balanced.Entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "teams_db")
@Getter
@Setter
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer teamId;
    @Column(name = "team_name")
    private String teamName;

    @ManyToOne
    GroupsOfUsers user;
}
