package com.mindheld.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mindheld.entity.GameResult;
import com.mindheld.entity.Student;

@Repository("gameResultRepository")
public interface GameResultRepository extends JpaRepository<GameResult, Serializable> {
	public List<GameResult> findByStudentOrderByGameAsc(Student student);
}
