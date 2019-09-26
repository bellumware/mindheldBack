package com.mindheld.service;

import com.mindheld.entity.Person;
import com.mindheld.model.BasicPersonDTO;
import com.mindheld.model.PersonDTO;

public interface PersonService {
	
	
	public PersonDTO findPersonById(String personId);
	public BasicPersonDTO findPersonBasicByUser(String user);
	public PersonDTO save(PersonDTO personDto);
	public Person save (Person person);
	public boolean edit(PersonDTO personDto);
    public void delete(Person person);
	
}
