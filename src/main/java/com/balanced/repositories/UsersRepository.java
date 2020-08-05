package com.balanced.repositories;
import com.balanced.Entities.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    List<Users> getUsersByGroupOfUsersForeignGroupNameAndTeamsForeignTeamName(String group, String name);

    @Query(value = "SELECT user_name FROM users_db JOIN groups_db gd on users_db.group_id = gd.group_id JOIN teams_db td on users_db.team_id = td.team_id WHERE group_name = ?1 AND team_name = ?2", nativeQuery = true)
    List<Users> showByGroupAndTeam(String grup, String name);

    @Modifying
    @Query(value = "update Users user set user.playerAverage = ?1 where user.userId=?2")
    void setAverage(Double average, int id);

    @Modifying
    @Query(value = "UPDATE users_db user set user.team_id = ?1 where user_id = ?2", nativeQuery = true)
    void balanceTeams(Integer teamId, Integer userId);

    @Query(value = "SELECT * from users_db join groups_db gd on users_db.group_id = gd.group_id where users_db.group_id = ?1 order by player_average desc", nativeQuery = true)
    List<Users> sortedUsersFromGroup (Integer groupId);



}
