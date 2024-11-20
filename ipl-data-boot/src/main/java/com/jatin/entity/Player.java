package com.jatin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Player {
	@Id
	@Column(name = "Jersey_no")
	private int jno;
	@Column(name = "Player_Name")
	private String pname;
	@Column(name = "Genre")
	private String genre;
	@Column(name = "Bid_Amount")
	private double bidAmnt;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "Team_Id", nullable = false)
	private Team team;

	public int getJno() {
		return jno;
	}

	public void setJno(int jno) {
		this.jno = jno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getBidAmnt() {
		return bidAmnt;
	}

	public void setBidAmnt(Long bidAmnt) {
		this.bidAmnt = bidAmnt;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
