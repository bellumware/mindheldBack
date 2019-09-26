package com.mindheld.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.Game;

@Repository("gameRepository")
public interface GameRepository extends JpaRepository<Game, Serializable>{
	
	public List<Game> findByEnabled(boolean enabled);

	public Game findByGameId(long gameId);
}
