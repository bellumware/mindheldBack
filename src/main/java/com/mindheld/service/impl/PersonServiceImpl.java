package com.mindheld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mindheld.components.PersonConverter;
import com.mindheld.entity.Person;
import com.mindheld.model.BasicPersonDTO;
import com.mindheld.model.PersonDTO;
import com.mindheld.repository.PersonRepository;
import com.mindheld.service.PersonService;
import com.mindheld.service.UserService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	@Qualifier("personRepository")
	private PersonRepository personRepository;

	@Autowired
	@Qualifier("personConverter")
	private PersonConverter personConverter;

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Override
	public PersonDTO findPersonById(String personId) {
		var entity = personRepository.findByPersonId(personId);
		return personConverter.entityToPersonDTO(entity);
	}
	
	

	@Override
	public BasicPersonDTO findPersonBasicByUser(String user) {
		var userResult = userService.findByUserName(user);
		return  personConverter.entityToBasicPersonDTO(userResult.getPerson());
	}



	@Override
	public PersonDTO save(PersonDTO personDto) {
		personRepository.save(personConverter.personDtoToEntity(personDto));
		return personDto;
	}

	@Override
	public boolean edit(PersonDTO personDto) {
		if (findPersonById(personDto.getPersonId()) != null) {
			save(personDto);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void delete(Person person) {
		person = personRepository.findByPersonId(person.getPersonId());
		person.getUsers().forEach(user -> userService.delete(user));
		personRepository.delete(person);

	}

}
