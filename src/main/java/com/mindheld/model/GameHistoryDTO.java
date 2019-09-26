package com.mindheld.model;

import java.sql.Timestamp;

public class GameHistoryDTO {
	private long gameHistoryId;
	private long gameId;
	private String studentId;
	private Timestamp startPlaying;
	private Timestamp endPlaying;
	
	
	public long getGameHistoryId() {
		return gameHistoryId;
	}
	public void setGameHistoryId(long gameHistoryId) {
		this.gameHistoryId = gameHistoryId;
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Timestamp getStartPlaying() {
		return startPlaying;
	}
	public void setStartPlaying(Timestamp startPlaying) {
		this.startPlaying = startPlaying;
	}
	public Timestamp getEndPlaying() {
		return endPlaying;
	}
	public void setEndPlaying(Timestamp endPlaying) {
		this.endPlaying = endPlaying;
	}

	
	
}
