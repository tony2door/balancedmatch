package com.balanced.repositories;

import com.balanced.Entities.GroupOfUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsRepository extends JpaRepository<GroupOfUsers, Integer> {

    @Query(value = "SELECT * FROM groups_db", nativeQuery = true )
    List<GroupOfUsers> getAllGroups();
}
