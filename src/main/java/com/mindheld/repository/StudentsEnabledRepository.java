package com.mindheld.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.StudentsEnabled;

@Repository("studentsEnabledRepository")
public interface StudentsEnabledRepository extends JpaRepository<StudentsEnabled, Serializable> {

}
