package com.jatin.service;

import java.util.List;

import com.jatin.entity.Player;

public interface PlayerService {

	public Player fetchPlayer(int jno);

	public Player savePlayer(Player player,int tid);

	public void removePlayer(int jno);
 
	public List<Player> getAllPlayers();
}
