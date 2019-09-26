package com.mindheld.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.Observation;
import com.mindheld.entity.Student;
import com.mindheld.entity.User;

@Repository("observationRepository")
public interface ObservationRepository extends JpaRepository<Observation, Serializable> {
	
	public List<Observation> findByUserAndEnabled(User user, boolean enbaled);
	public List<Observation> findByStudentAndEnabled(Student student, boolean enbaled, Sort sort);
	public List<Observation> findByUser(User user);
	public List<Observation> findByStudent(Student student, Sort sort);
	public Observation findByObservationId(long observationId);

}
