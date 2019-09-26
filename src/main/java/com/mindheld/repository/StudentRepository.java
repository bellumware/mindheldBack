package com.mindheld.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Serializable> {

	
	public Student findByStudentId(String studentId);
	
	public List<Student> findByEnabled(boolean enabled);
	
	
}
