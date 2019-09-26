package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the GAMES database table.
 * 
 */
@Entity
@Table(name = "GAMES")
@NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@SequenceGenerator(name = "GAMES_GAMEID_GENERATOR", sequenceName = "GAMES_SEQ")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GAMES_GAMEID_GENERATOR")
	@GeneratedValue
	@Column(name = "GAME_ID", unique = true, nullable = false)
	private long gameId;

	@Column(nullable = false, length = 500)
	private String url;

	@Column(nullable = false)
	private boolean enabled;
	
	@Column(name ="PHOTO")
	private String photo;

	@Column(name ="NAME")
	private String name;

	// bi-directional many-to-one association to GamesHistory
	@OneToMany(mappedBy = "game")
	private List<GamesHistory> gamesHistories;

	public Game() {
	}

	public long getGameId() {
		return this.gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<GamesHistory> getGamesHistories() {
		return this.gamesHistories;
	}

	public void setGamesHistories(List<GamesHistory> gamesHistories) {
		this.gamesHistories = gamesHistories;
	}

	public GamesHistory addGamesHistory(GamesHistory gamesHistory) {
		getGamesHistories().add(gamesHistory);
		gamesHistory.setGame(this);

		return gamesHistory;
	}

	public GamesHistory removeGamesHistory(GamesHistory gamesHistory) {
		getGamesHistories().remove(gamesHistory);
		gamesHistory.setGame(null);

		return gamesHistory;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}