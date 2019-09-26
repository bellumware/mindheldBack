package com.mindheld.service;

import java.util.List;

import com.mindheld.entity.Person;
import com.mindheld.model.PersonDTO;

public interface TeacherService {

	public void createTeacher(Person person) throws Exception;
	public void editTeacher(Person person);
	public void deleteTeacher(Person person);
	public List<PersonDTO> findTeachers();
	
}
