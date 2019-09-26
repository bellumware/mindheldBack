package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_NAME", unique = true, nullable = false, length = 20)
	private String userName;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATION", nullable = false)
	private Date dateCreation;

	@Column(nullable = false)
	private boolean enabled;

	@Column(name = "NEED_CHANGE_PASS", nullable = false, precision = 22)
	private BigDecimal needChangePass;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(name = "USER_CREATION", nullable = false, length = 20)
	private String userCreation;

	// bi-directional many-to-one association to Observation
	@OneToMany(mappedBy = "user")
	private List<Observation> observations;

	// bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name = "PERSON_ID", nullable = false)
	private Person person;

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "ROLE_ID", nullable = false)
	private Role role;

	public User() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public BigDecimal getNeedChangePass() {
		return this.needChangePass;
	}

	public void setNeedChangePass(BigDecimal needChangePass) {
		this.needChangePass = needChangePass;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserCreation() {
		return this.userCreation;
	}

	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}

	public List<Observation> getObservations() {
		return this.observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	public Observation addObservation(Observation observation) {
		getObservations().add(observation);
		observation.setUser(this);

		return observation;
	}

	public Observation removeObservation(Observation observation) {
		getObservations().remove(observation);
		observation.setUser(null);

		return observation;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}