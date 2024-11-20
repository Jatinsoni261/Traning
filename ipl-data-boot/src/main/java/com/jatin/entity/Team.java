package com.jatin.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Team")
public class Team {
	@Id
	@Column(name = "Team_Id")
	private int tid;
	@Column(name = "Team_Name", length = 30)
	private String name;
	@Column(name = "Owner", length = 15)
	private String ownerName;

	@JsonManagedReference
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Player> player;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

}
