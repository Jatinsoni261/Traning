package com.jatin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.jatin.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	@Query("from Player where team.tid =: tid")
	List<Player> findByTeam(@Param("tid") int tid);
} 
 