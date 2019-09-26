package com.mindheld.model;

public class AuthToken {

	private String token;
	private String role;
	private BasicPersonDTO personData;
	public AuthToken() {

	}

	public AuthToken(String token) {
		this.token = token;
	}

	public AuthToken(String token, String role, BasicPersonDTO personData) {
		super();
		this.token = token;
		this.role = role;
		this.personData = personData;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public BasicPersonDTO getPersonData() {
		return personData;
	}

	public void setPersonData(BasicPersonDTO personData) {
		this.personData = personData;
	}
	
	

}
