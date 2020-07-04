package com.balanced.Entities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Table(name = "groups_db")
@Getter
@Setter
@Entity
public class GroupsOfUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "group_name")
    private String groupName;

    @OneToMany
    List<Users>userList;

    @OneToMany
    @JoinColumn(name = "team_id")
    List<Teams> teamsForeign;
}

