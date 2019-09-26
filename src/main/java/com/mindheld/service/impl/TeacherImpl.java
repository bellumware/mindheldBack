package com.mindheld.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindheld.components.PersonConverter;
import com.mindheld.entity.Person;
import com.mindheld.entity.Role;
import com.mindheld.entity.User;
import com.mindheld.model.PersonDTO;
import com.mindheld.repository.PersonRepository;
import com.mindheld.service.PersonService;
import com.mindheld.service.TeacherService;
import com.mindheld.service.UserService;

@Service("teacherService")
public class TeacherImpl extends LogAppService implements TeacherService {

	@Autowired
	PersonService personService;
	@Autowired
	UserService userService;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PersonConverter personConverter;

	@Override
	public void createTeacher(Person person) throws Exception {
		if(personRepository.findByPersonId(person.getPersonId()) != null) {
			throw new Exception("teacher with id: ["+ person.getPersonId() +"] already exists");
		}
		personService.save(person);
		var user = new User();
		user.setDateCreation(new Date());
		user.setEnabled(true);
		user.setNeedChangePass(BigDecimal.ZERO);
		user.setPerson(person);
		user.setUserName(person.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(person.getPersonId()));
		var role = new Role();
		role.setRoleId(2);
		user.setRole(role);
		user.setUserCreation(SecurityContextHolder.getContext().getAuthentication().getName());
		userService.save(user);
		saveLog("teacher with id: [" + person.getPersonId() + "] created");
	}

	@Override
	public void editTeacher(Person person) {
		personService.save(person);
	}
	
	@Override
	public void deleteTeacher(Person person) {
		personService.delete(person);
	}
	
	@Override
	public List<PersonDTO> findTeachers() {
		List<Person> teachers = new ArrayList<Person>(personRepository.findTeachers());
		ArrayList<PersonDTO> teachersResult = new ArrayList<PersonDTO>();
		teachers.forEach(teacher -> teachersResult.add(personConverter.entityToPersonDTO(teacher)));
		return teachersResult;
	}
}
