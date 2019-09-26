package com.mindheld.model;

import java.util.Date;

public class ObservationsDTO {

	private long observationId;
	private String observation;
	private Date observationDate;
	private String studentId;
	private String userName;
	private String supportFile;
	private boolean enabled;

	public ObservationsDTO() {
	}

	public ObservationsDTO(long observationId, String observation, Date observationDate, String studentId,
			String userName, String supportFile, boolean enabled) {
		super();
		this.observationId = observationId;
		this.observation = observation;
		this.observationDate = observationDate;
		this.studentId = studentId;
		this.userName = userName;
		this.supportFile = supportFile;
		this.enabled = enabled;
	}

	public long getObservationId() {
		return observationId;
	}

	public void setObservationId(long observationId) {
		this.observationId = observationId;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getObservationDate() {
		return observationDate;
	}

	public void setObservationDate(Date observationDate) {
		this.observationDate = observationDate;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSupportFile() {
		return supportFile;
	}

	public void setSupportFile(String supportFile) {
		this.supportFile = supportFile;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
