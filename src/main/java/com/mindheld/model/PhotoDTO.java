package com.mindheld.model;

import com.mindheld.entity.Person;
import com.mindheld.entity.Student;

public class PhotoDTO {

	private String photoPath;
	private Student student;
	private Person person;

	public PhotoDTO() {
	}

	public PhotoDTO(String photoPath, Student student, Person person) {
		super();
		this.photoPath = photoPath;
		this.student = student;
		this.person = person;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
