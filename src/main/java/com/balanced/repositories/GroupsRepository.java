package com.balanced.repositories;

import com.balanced.Entities.GroupOfUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<GroupOfUsers, Integer> {

}
