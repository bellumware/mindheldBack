package com.mindheld.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.GamesHistory;


@Repository("gameHistoryRepository")
public interface GameHistoryRepository extends JpaRepository<GamesHistory, Serializable> {

	
}
