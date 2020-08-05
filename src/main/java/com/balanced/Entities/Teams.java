package com.balanced.Entities;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teams_db")
@Getter
@Setter
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer teamId;
    @Column(name = "team_name", nullable = false)
    private String teamName;

    @OneToMany(mappedBy = "teamsForeign")
    List<Users> usersList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teams teams = (Teams) o;
        return Objects.equals(teamId, teams.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId);
    }
}
