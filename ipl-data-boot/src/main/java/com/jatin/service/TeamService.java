package com.jatin.service;

import java.util.List;

import com.jatin.entity.Team;

public interface TeamService {
	public Team fetchTeam(int tid);

	public Team saveTeam(Team team);

	public void removeTeam(int tid);

	public List<Team> getAllTeams();
}
