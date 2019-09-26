package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the OBSERVATIONS database table.
 * 
 */
@Entity
@Table(name = "OBSERVATIONS")
@NamedQuery(name = "Observation.findAll", query = "SELECT o FROM Observation o")
public class Observation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(name = "OBSERVATIONS_OBSERVATIONID_GENERATOR", sequenceName = "OBSERVATIONS_SEQ", allocationSize=1)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBSERVATIONS_OBSERVATIONID_GENERATOR")
	@GeneratedValue
	@Column(name = "OBSERVATION_ID", unique = true, nullable = false)
	private long observationId;

	@Column(nullable = false, length = 4000)
	private String observation;

	@Temporal(TemporalType.DATE)
	@Column(name = "OBSERVATION_DATE", nullable = false)
	private Date observationDate;

	@Column(name = "SUPPORT_FILE", length = 500)
	private String supportFile;

	@Column(nullable = false)
	private boolean enabled;

	// bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	private Student student;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "USER_NAME", nullable = false)
	private User user;

	public Observation() {
	}

	public long getObservationId() {
		return this.observationId;
	}

	public void setObservationId(long observationId) {
		this.observationId = observationId;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getObservationDate() {
		return this.observationDate;
	}

	public void setObservationDate(Date observationDate) {
		this.observationDate = observationDate;
	}

	public String getSupportFile() {
		return this.supportFile;
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

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}