package com.mindheld.service;

import java.util.List;

import com.mindheld.entity.Student;
import com.mindheld.model.StudentBasicDTO;
import com.mindheld.model.StudentDTO;

public interface StudentService {

	
	public List<StudentBasicDTO> findAllBasic();
	public List<StudentBasicDTO> findAllEnabledsBasic();	
	public StudentDTO findStudentById(String studentId);
	public Student findStudentEntityById(String studentId);
	public StudentDTO save(StudentDTO student);
	public boolean edit(StudentDTO student);
    public void delete(String studentId);
}
