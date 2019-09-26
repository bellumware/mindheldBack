package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PHOTOS database table.
 * 
 */
@Entity
@Table(name="PHOTOS")
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(name="PHOTOS_PHOTOID_GENERATOR", sequenceName="PHOTOS_SEQ", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PHOTOS_PHOTOID_GENERATOR")
	@GeneratedValue
	@Column(name="PHOTO_ID", unique=true, nullable=false)
	private long photoId;

	@Column(name="\"PATH\"", nullable=false, length=500)
	private String path;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;

	public Photo() {
	}

	public long getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}