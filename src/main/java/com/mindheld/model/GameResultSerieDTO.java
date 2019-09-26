package com.mindheld.model;

import java.util.ArrayList;
import java.util.List;

public class GameResultSerieDTO {

	private String name;
	private List<Integer> data;
	
	public GameResultSerieDTO() {
		data = new ArrayList<Integer>();
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Integer> getData() {
		return data;
	}


	public void setData(List<Integer> data) {
		this.data = data;
	}


	

	

	
	
}
