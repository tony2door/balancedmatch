package com.balanced.Entities;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "teamsForeign")
    List<Users> usersList;


}
