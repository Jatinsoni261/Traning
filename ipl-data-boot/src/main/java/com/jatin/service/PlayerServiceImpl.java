package com.jatin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatin.entity.Player;
import com.jatin.entity.Team;
import com.jatin.repo.PlayerRepository;
import com.jatin.repo.TeamRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerRepo;
	
	@Autowired
	private TeamService tservice;

	public List<Player> getAllPlayers() {
		return playerRepo.findAll();
	}

	@Override
	public Player fetchPlayer(int jno) {
		// TODO Auto-generated method stub
		return playerRepo.findById(jno).get();
	}

	@Override
	public void removePlayer(int jno) {
		// TODO Auto-generated method stub
		playerRepo.deleteById(jno);
	}

	@Override
	public Player savePlayer(Player player, int tid) {
		// TODO Auto-generated method stub
		Team team = tservice.fetchTeam(tid);
		player.setTeam(team);
		return playerRepo.save(player); 
	}
}
