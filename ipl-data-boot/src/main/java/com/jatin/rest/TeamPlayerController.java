package com.jatin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.Delimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jatin.entity.Player;
import com.jatin.entity.Team;
import com.jatin.service.PlayerService;
import com.jatin.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamPlayerController {

	@Autowired
	private TeamService tservice;

	@Autowired
	private PlayerService pservice;

	// For Team
	@PostMapping(value = "/save", consumes = "application/json")
	public String save(@RequestBody Team t) {
		tservice.saveTeam(t);
		return "Team Saved";
	} 

	@GetMapping(value = "/list", produces = "application/json")
	public List<Team> list() {
		return tservice.getAllTeams();
	}

	@GetMapping(value = "/fetch", produces = "application/json")
	public Team fetchTeam(int tid) {
		return tservice.fetchTeam(tid);
	}

	@Delimiter(value = "/remove/{tid}" )
	public String deleteTeam(@PathVariable int tid) {
		tservice.removeTeam(tid);
		return "Team Deleted";
	}

	// For Player
	@PostMapping(value = "/Player/save/{tid}", consumes = "application/json")
	public String savePlayer(@RequestBody Player p,@PathVariable int tid) {
		pservice.savePlayer(p,tid);
		return "Player Saved";
	} 
 
	@GetMapping(value = "/Player/fetch", produces = "application/json")
	public Player fetch(int jno) {
		return pservice.fetchPlayer(jno);
	}

	@GetMapping(value = "/Player/list", produces = "application/json")
	public List<Player> listPlayer() {
		return pservice.getAllPlayers();
	}
 
	@Delimiter(value = "/Player/remove")
	public String deletePlayer(int jno) {
		pservice.removePlayer(jno);
		return "Player Deleted";
	}

}
