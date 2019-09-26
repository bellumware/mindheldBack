package com.mindheld.model;

import com.mindheld.entity.Game;

public class GameDTO {

	private long gameId;
	private String url;
	private String photo;
	private String name;
	private boolean enabled;

	public GameDTO() {
	}

	public GameDTO(Object game) {
		if (game != null && game instanceof Game) {
			var _game 		= (Game) game;
			this.gameId 	= _game.getGameId();
			this.url 		= _game.getUrl();
			this.enabled 	= _game.isEnabled();
			this.photo 		= _game.getPhoto();
			this.name		= _game.getName();
		}
	}

	public GameDTO(long gameId, String url, boolean enabled) {
		this.gameId = gameId;
		this.url = url;
		this.enabled = enabled;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getUrl() {
		return url;
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
