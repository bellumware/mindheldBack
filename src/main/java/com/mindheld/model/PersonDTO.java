package com.mindheld.model;

import java.util.Date;

import com.mindheld.util.Utils;

public class PersonDTO {

	private String personId;
	private String address;
	private Date birthDate;
	private String email;
	private String firstName;
	private String firstSurname;
	private String secondName;
	private String secondSurname;
	private String age;
	private String photo;
	public String fullName;

	public PersonDTO() {

	}

	public PersonDTO(String personId, String address, Date birthDate, String email, String firstName,
			String firstSurname, String secondName, String secondSurname, String photo) {
		super();
		this.personId = personId;
		this.address = address;
		this.birthDate = birthDate;
		this.email = email;
		this.firstName = firstName;
		this.firstSurname = firstSurname;
		this.secondName = secondName;
		this.secondSurname = secondSurname;
		this.photo = photo;
		this.age = Utils.calculateAge(birthDate);
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		if(birthDate != null)
			setAge(Utils.calculateAge(birthDate));
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
}
