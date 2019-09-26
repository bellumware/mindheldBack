package com.mindheld.model;

import java.util.List;

public class StudentDTO {

	private boolean enabled;
	private PersonDTO student;
	private List<PersonDTO> parents;
	private List<ObservationsDTO> observations;

	public StudentDTO() {
	}

	public StudentDTO(boolean enabled, PersonDTO student, List<PersonDTO> parents, List<ObservationsDTO> observations) {
		super();
		this.enabled = enabled;
		this.student = student;
		this.parents = parents;
		this.observations = observations;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public PersonDTO getStudent() {
		return student;
	}

	public void setStudent(PersonDTO student) {
		this.student = student;
	}

	public List<PersonDTO> getParents() {
		return parents;
	} 

	public void setParents(List<PersonDTO> parents) {
		this.parents = parents;
	}

	public List<ObservationsDTO> getObservations() {
		return observations;
	}

	public void setObservations(List<ObservationsDTO> observations) {
		this.observations = observations;
	}

}
