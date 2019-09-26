package com.mindheld.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.StudentsCreateStatistic;

@Repository("studentsCreateStatisticRepository")
public interface StudentsCreateStatisticRepository  extends JpaRepository<StudentsCreateStatistic, Serializable> {
}
