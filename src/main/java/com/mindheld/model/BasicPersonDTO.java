package com.mindheld.model;

public class BasicPersonDTO {
	private String fullName;
	private String id;

	public BasicPersonDTO() {}
	
	public BasicPersonDTO(String fullName, String id) {
		super();
		this.fullName = fullName;
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
