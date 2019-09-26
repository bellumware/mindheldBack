package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the STUDENTS database table.
 * 
 */
@Entity
@Table(name = "STUDENTS")
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STUDENT_ID", unique = true, nullable = false, length = 50)
	private String studentId;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE", nullable = false)
	private Date birthDate;

	@Column(name = "FIRST_NAME", nullable = false, length = 20)
	private String firstName;

	@Column(name = "FIRST_SURNAME", nullable = false, length = 20)
	private String firstSurname;

	@Column(name = "SECOND_NAME", length = 20)
	private String secondName;

	@Column(name = "SECOND_SURNAME", length = 20)
	private String secondSurname;

	@Column(nullable = false)
	private boolean enabled;

	// bi-directional many-to-one association to GamesHistory
	@OneToMany(mappedBy = "student")
	private List<GamesHistory> gamesHistories;

	// bi-directional many-to-one association to Observation
	@OneToMany(mappedBy = "student")
	private List<Observation> observations;

	// bi-directional many-to-many association to Person
	@ManyToMany
	@JoinTable(name = "PARENTS", joinColumns = {
			@JoinColumn(name = "STUDENT_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "PERSON_ID", nullable = false) })
	private List<Person> persons;

	// bi-directional many-to-one association to Photo
	@OneToMany(mappedBy = "student")
	private List<Photo> photos;

	public Student() {
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstSurname() {
		return this.firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSecondSurname() {
		return this.secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<GamesHistory> getGamesHistories() {
		return this.gamesHistories;
	}

	public void setGamesHistories(List<GamesHistory> gamesHistories) {
		this.gamesHistories = gamesHistories;
	}

	public GamesHistory addGamesHistory(GamesHistory gamesHistory) {
		getGamesHistories().add(gamesHistory);
		gamesHistory.setStudent(this);

		return gamesHistory;
	}

	public GamesHistory removeGamesHistory(GamesHistory gamesHistory) {
		getGamesHistories().remove(gamesHistory);
		gamesHistory.setStudent(null);

		return gamesHistory;
	}

	public List<Observation> getObservations() {
		return this.observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	public Observation addObservation(Observation observation) {
		getObservations().add(observation);
		observation.setStudent(this);

		return observation;
	}

	public Observation removeObservation(Observation observation) {
		getObservations().remove(observation);
		observation.setStudent(null);

		return observation;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setStudent(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setStudent(null);

		return photo;
	}

	@Override
	public boolean equals(Object obj) {
		Student compare;
		if(obj instanceof Student)
			compare = (Student)obj;
		else return false;
		
		if(compare != null && 
		   compare.getStudentId() != null && 
		  !compare.getStudentId().isBlank() &&
		   compare.equals(getStudentId())) {
			return true;
		}else return false;
		
	}
	
	

}