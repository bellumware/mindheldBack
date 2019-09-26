package com.mindheld.repository;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.Person;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Serializable>{
	
	public Person findByPersonId(String personId);
	
	@Query("select p from Person p inner join User u on p.personId = u.person where u.role = 2")
	public Collection<Person> findTeachers();

}
