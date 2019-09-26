package com.mindheld.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prueba {

	@Id
	@Column(name="GAMES_HISTORY_ID")
	private String algo;
	@Column(name="STUDENT_ID")
	private String otro;

	public String getAlgo() {
		return algo;
	}

	public void setAlgo(String algo) {
		this.algo = algo;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

}
