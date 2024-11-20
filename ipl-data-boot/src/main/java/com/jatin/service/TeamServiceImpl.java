package com.jatin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatin.entity.Team;
import com.jatin.repo.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepo;

	@Override
	public Team fetchTeam(int tid) {
		// TODO Auto-generated method stub
		return teamRepo.findById(tid).get();
	}

	@Override
	public Team saveTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepo.save(team);
	}

	@Override
	public void removeTeam(int tid) {
		// TODO Auto-generated method stub 
	 teamRepo.deleteById(tid); 
	}

	@Override
	public java.util.List<Team> getAllTeams() {
		// TODO Auto-generated method stub
		return teamRepo.findAll();  
	}

}
