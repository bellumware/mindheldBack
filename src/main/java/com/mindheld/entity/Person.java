package com.mindheld.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PERSONS database table.
 * 
 */
@Entity
@Table(name="PERSONS")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PERSON_ID", unique=true, nullable=false, length=50)
	private String personId;

	@Column(length=20)
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

	@Column(length=20)
	private String email;

	@Column(name="FIRST_NAME", nullable=false, length=20)
	private String firstName;

	@Column(name="FIRST_SURNAME", nullable=false, length=20)
	private String firstSurname;

	@Column(name="SECOND_NAME", length=20)
	private String secondName;

	@Column(name="SECOND_SURNAME", length=20)
	private String secondSurname;
	
	//bi-directional many-to-many association to Student
	@ManyToMany(mappedBy="persons")
	private List<Student> students;

	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="person")
	private List<Photo> photos;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="person")
	private List<User> users;

	public Person() {
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Photo addPhoto(Photo photo) {
		getPhotos().add(photo);
		photo.setPerson(this);

		return photo;
	}

	public Photo removePhoto(Photo photo) {
		getPhotos().remove(photo);
		photo.setPerson(null);

		return photo;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setPerson(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setPerson(null);

		return user;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person compare;
		if(obj instanceof Person)
			compare = (Person)obj;
		else return false;
		
		if(compare != null && 
		   compare.getPersonId() != null && 
		  !compare.getPersonId().isBlank() &&
		   compare.equals(getPersonId())) {
			return true;
		}else return false;
		
	}

	
	

}