package com.balanced.repositories;

import com.balanced.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    List<Users> getUsersByGroupOfUsersForeignGroupNameAndTeamsForeignTeamName(String group, String name);

}
