package com.mindheld.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.GamesStatistics;

@Repository("gamesStatisticsRepository")
public interface GamesStatisticsRepository extends JpaRepository<GamesStatistics, Serializable> {
	
	public List<GamesStatistics> findByStudentId(String studentId);
	

}
