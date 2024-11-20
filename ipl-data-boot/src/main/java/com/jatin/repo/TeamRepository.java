package com.jatin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatin.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {


}
