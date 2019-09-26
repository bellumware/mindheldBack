package com.mindheld.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.ObservationPerUserStatistic;

@Repository
public interface ObservationPerUserStatisticRepository extends JpaRepository<ObservationPerUserStatistic, Serializable>{
	public List<ObservationPerUserStatistic> findByStudentId(String studentId);
}
