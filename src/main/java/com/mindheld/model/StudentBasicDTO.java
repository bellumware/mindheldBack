package com.mindheld.model;


public class StudentBasicDTO {

	private String personId;
	private String fullName;
	private String photoUrl;
	private boolean enabled;
	private int observationsCount = 0;

	public StudentBasicDTO() {
	}

	public StudentBasicDTO(String fullName, String photoUrl) {
		super();
		this.fullName = fullName;
		this.photoUrl = photoUrl;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public int getObservationsCount() {
		return observationsCount;
	}

	public void setObservationsCount(int observationsCount) {
		this.observationsCount = observationsCount;
	}
	

}
