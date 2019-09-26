package com.mindheld.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.ObservationStatistic;;

@Repository
public interface ObservationStatisticRepository extends JpaRepository<ObservationStatistic, Serializable>{
	public List<ObservationStatistic> findByStudentId(String studentId);
}
