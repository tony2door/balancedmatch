package com.balanced.Entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "groups_db")
@Getter
@Setter
@Entity
public class GroupOfUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "groupOfUsersForeign")
    List<Users>listOfUsersInGroup;




}

