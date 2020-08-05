package com.balanced.Entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "groups_db")
@Getter
@Setter
@Entity
public class GroupOfUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "group_name", nullable = false)
    private String groupName;

    @OneToMany(mappedBy = "groupOfUsersForeign")
    List<Users>listOfUsersInGroup;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupOfUsers that = (GroupOfUsers) o;
        return Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId);
    }

    @Override
    public String toString() {
        return "GroupOfUsers{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\''+
                '}';
    }
}

