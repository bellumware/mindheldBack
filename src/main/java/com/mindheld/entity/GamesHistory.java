package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the GAMES_HISTORY database table.
 * 
 */
@Entity
@Table(name="GAMES_HISTORY")
@NamedQuery(name="GamesHistory.findAll", query="SELECT g FROM GamesHistory g")
public class GamesHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(name="GAMES_HISTORY_GAMESHISTORYID_GENERATOR", sequenceName="GAMES_HISTORY_SEQ", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GAMES_HISTORY_GAMESHISTORYID_GENERATOR")
	@GeneratedValue
	@Column(name="GAMES_HISTORY_ID", unique=true, nullable=false)
	private long gamesHistoryId;

	@Column(name="END_PLAYING", nullable=false)
	private Timestamp endPlaying;

	@Column(name="START_PLAYING", nullable=false)
	private Timestamp startPlaying;

	//bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name="GAME_ID", nullable=false)
	private Game game;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="STUDENT_ID", nullable=false)
	private Student student;

	public GamesHistory() {
	}

	public long getGamesHistoryId() {
		return this.gamesHistoryId;
	}

	public void setGamesHistoryId(long gamesHistoryId) {
		this.gamesHistoryId = gamesHistoryId;
	}

	public Timestamp getEndPlaying() {
		return this.endPlaying;
	}

	public void setEndPlaying(Timestamp endPlaying) {
		this.endPlaying = endPlaying;
	}

	public Timestamp getStartPlaying() {
		return this.startPlaying;
	}

	public void setStartPlaying(Timestamp startPlaying) {
		this.startPlaying = startPlaying;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}