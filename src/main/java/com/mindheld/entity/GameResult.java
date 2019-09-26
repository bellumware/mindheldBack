package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the GAMES database table.
 * 
 */
@Entity
@Table(name = "GAMES_RESULT")
public class GameResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "GAME_RESULT_ID")
	private long gamreResultId;

	@Column(name = "SUCCESS")
	private int success;
	
	@Column(name = "FAILS")
	private int fails;
	
	@ManyToOne
	@JoinColumn(name="GAME_ID", nullable=false)
	private Game game;
	
	@ManyToOne
	@JoinColumn(name="STUDENT_ID", nullable=false)
	private Student student;
	

	public long getGamreResultId() {
		return gamreResultId;
	}


	public void setGamreResultId(long gamreResultId) {
		this.gamreResultId = gamreResultId;
	}

	public int getSuccess() {
		return success;
	}


	public void setSuccess(int success) {
		this.success = success;
	}


	public int getFails() {
		return fails;
	}


	public void setFails(int fails) {
		this.fails = fails;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	

}