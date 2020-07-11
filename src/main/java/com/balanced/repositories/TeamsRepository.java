package com.balanced.repositories;

import com.balanced.Entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamsRepository extends JpaRepository<Teams,Integer> {
    @Query(value = "SELECT * FROM teams_db", nativeQuery = true )
    List<Teams>getAllTeams();
}
