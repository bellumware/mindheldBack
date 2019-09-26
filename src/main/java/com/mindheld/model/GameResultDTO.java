package com.mindheld.model;

public class GameResultDTO {

	private String gameName;
	private GameResultSerieDTO success;
	private GameResultSerieDTO fails;
	private int[] xaxis;
	
	public GameResultDTO() {
		gameName = "";
		success = new GameResultSerieDTO();
		fails = new GameResultSerieDTO();
		success.setName("Aciertos");
		fails.setName("Desaciertos");
	}
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public GameResultSerieDTO getSuccess() {
		return success;
	}
	public void setSuccess(GameResultSerieDTO success) {
		this.success = success;
	}
	public GameResultSerieDTO getFails() {
		return fails;
	}
	public void setFails(GameResultSerieDTO fails) {
		this.fails = fails;
	}
	public int[] getXaxis() {
		return xaxis;
	}
	public void setXaxis(int[] xaxis) {
		this.xaxis = xaxis;
	}
	
	public void addSucces(int result) {
		success.getData().add(result);
	}
	
	public void addFail(int result) {
		fails.getData().add(result);
	}
	
	public void generateXaxis() {
		xaxis = new int[success.getData().size()];
		for(int i=0; i < success.getData().size() ; i++) {
			xaxis[i] = i+1;
		}
	}
	
	
}
