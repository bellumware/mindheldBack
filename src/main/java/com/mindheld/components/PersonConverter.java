package com.mindheld.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mindheld.entity.Person;
import com.mindheld.entity.Student;
import com.mindheld.model.BasicPersonDTO;
import com.mindheld.model.PersonDTO;
import com.mindheld.model.StudentBasicDTO;
import com.mindheld.model.StudentDTO;
import com.mindheld.util.Utils;

@Component("personConverter")
public class PersonConverter {
	
	@Autowired
	@Qualifier("observationConverter")
	private ObservationConverter observationConverter;
	
	public List<StudentBasicDTO> convertTobasicDTO(List<Student> students) {
		var _return = new ArrayList<StudentBasicDTO>();
		students.forEach(student -> _return.add(convertTobasicDTO(student)));
		return _return;
	}
	
	public StudentBasicDTO convertTobasicDTO(Student student) {
		var _return = new StudentBasicDTO();
		_return.setPersonId(student.getStudentId());
		_return.setFullName(Utils.concatNames(student));
		_return.setEnabled(student.isEnabled());
		if(student.getObservations() != null)
			_return.setObservationsCount(student.getObservations().size());
		if(student.getPhotos() != null && !student.getPhotos().isEmpty() && student.getPhotos().get(0) != null)
			_return.setPhotoUrl(student.getPhotos().get(0).getPath());
		return _return;
	}

	public Student studentDtoToEntity(StudentDTO studentDto) {
		var _return = new Student();
		_return.setStudentId(studentDto.getStudent().getPersonId());
		_return.setFirstName(studentDto.getStudent().getFirstName());
		_return.setSecondName(studentDto.getStudent().getSecondName());
		_return.setFirstSurname(studentDto.getStudent().getFirstSurname());
		_return.setSecondSurname(studentDto.getStudent().getSecondSurname());
		_return.setBirthDate(studentDto.getStudent().getBirthDate());
		_return.setEnabled(studentDto.isEnabled());

		return _return;
	}

	public Person personDtoToEntity(PersonDTO personDto) {
		var _return = new Person();
		_return.setPersonId(personDto.getPersonId());
		_return.setFirstName(personDto.getFirstName());
		_return.setSecondName(personDto.getSecondName());
		_return.setFirstSurname(personDto.getFirstSurname());
		_return.setSecondSurname(personDto.getSecondSurname());
		_return.setBirthDate(personDto.getBirthDate());
		_return.setAddress(personDto.getAddress());
		_return.setEmail(personDto.getEmail());

		return _return;

	}

	public StudentDTO entityToStudentDTO(Student student) {
		var _return = new StudentDTO();
		var person = new PersonDTO();
		person.setPersonId(student.getStudentId());
		person.setFirstName(student.getFirstName());
		person.setSecondName(student.getSecondName());
		person.setFirstSurname(student.getFirstSurname());
		person.setSecondSurname(student.getSecondSurname());
		person.setBirthDate(student.getBirthDate());
		person.setPhoto(getPhotoPathFromPerson(student));
		person.setAge(Utils.calculateAge(person.getBirthDate()));
		person.setFullName(Utils.concatNames(student));
		_return.setStudent(person);
		_return.setParents(listEntitiesToListPersonDTO(student.getPersons()));
		_return.setObservations(observationConverter.ListEntitysToDtos(student.getObservations()));
		_return.setEnabled(student.isEnabled());
		return _return;

	}
	
	public PersonDTO entityToPersonDTO(Person person) {
		var _return = new PersonDTO();
		_return.setPersonId(person.getPersonId());
		_return.setFirstName(person.getFirstName());
		_return.setSecondName(person.getSecondName());
		_return.setFirstSurname(person.getFirstSurname());
		_return.setSecondSurname(person.getSecondSurname());
		_return.setBirthDate(person.getBirthDate());
		_return.setAddress(person.getAddress());
		_return.setEmail(person.getEmail());
		_return.setPhoto(getPhotoPathFromPerson(person));
		_return.setFullName(Utils.concatNames(person));
		return _return;
		
	}
	
	public BasicPersonDTO entityToBasicPersonDTO(Person person) {
		var _return = new BasicPersonDTO();
		_return.setFullName(Utils.concatNames(person));
		_return.setId(person.getPersonId());
		return _return;
		
	}

	public List<PersonDTO> listEntitiesToListPersonDTO(List<Person> entities) {
		var persons = new ArrayList<PersonDTO>();
		entities.forEach(entity -> {			
			persons.add(entityToPersonDTO(entity));
		});
		return persons;
	}
	
	public String getPhotoPathFromPerson(Student student) {
		if(student.getPhotos() != null && !student.getPhotos().isEmpty()) {
			return (student.getPhotos().get(0) != null)
					?student.getPhotos().get(0).getPath()
					:"";
		}
		return "";
	}
	
	public String getPhotoPathFromPerson(Person person) {
		if(person.getPhotos() != null && !person.getPhotos().isEmpty()) {
			return (person.getPhotos().get(0) != null)
					?person.getPhotos().get(0).getPath()
					:"";
		}
		return "";
	}
}
