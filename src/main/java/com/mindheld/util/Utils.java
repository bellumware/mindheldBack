package com.mindheld.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;

import com.mindheld.entity.Person;
import com.mindheld.entity.Student;


public class Utils {

	private static String WHITE_SPACE = " ";
	public static String calculateAge(Date birth) {
		var _currentYear = LocalDate.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
		var _birth = LocalDate.ofInstant(Instant.ofEpochMilli(birth.getTime()), ZoneId.systemDefault());
		return (birth == null)
				? "0"
				: String.valueOf(Period.between(_birth, _currentYear).getYears());
	}
	
	public static String concatNames(Student student) {
		var fullname = new StringBuilder(student.getFirstName()).append(WHITE_SPACE);
		fullname.append(student.getSecondName()).append(WHITE_SPACE)
				.append(student.getFirstSurname()).append(WHITE_SPACE)
				.append(student.getSecondSurname());
		return fullname.toString().replace(" null", "");		
	}
	
	public static String concatNames(Person person) {
		var fullname = new StringBuilder(person.getFirstName()).append(WHITE_SPACE);
		fullname.append(person.getSecondName()).append(WHITE_SPACE)
				.append(person.getFirstSurname()).append(WHITE_SPACE)
				.append(person.getSecondSurname());
		return fullname.toString().replace(" null", "");		
	}
	
	public static boolean isValidString(String value) {
		return (value != null && !value.isBlank());		
	}
	
	public static String getFirstRoleFromAuthorities(Collection<? extends GrantedAuthority>  authorities) {
		return authorities.stream().collect(Collectors.toList()).get(0).getAuthority();		
	}
	
}
