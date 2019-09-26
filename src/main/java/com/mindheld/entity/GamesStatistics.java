package com.mindheld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="games_statistics")
public class GamesStatistics {

	@Id
	@Column(name="game_name")
	private String gameName;
	
	@Column(name="quantity")
	private String quantity;	

	@Column(name="student_id")
	private String studentId;

	@Column(name="hours_played")
	private String hoursPlayed;

	public GamesStatistics() {
		
	}
	
	public GamesStatistics(String gameName, String studentId) {
		this.gameName = gameName;
		this.studentId = studentId;
		this.quantity = "0";
		this.hoursPlayed = "0";
	}
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getHoursPlayed() {
		return hoursPlayed;
	}

	public void setHoursPlayed(String hoursPlayed) {
		this.hoursPlayed = hoursPlayed;
	}


	
	
}
