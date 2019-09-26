package com.mindheld.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.Prueba;

@Repository
public interface pruebaRepository extends JpaRepository<Prueba, Serializable>{
	
	@Query( value = "select gh.GAMES_HISTORY_ID, STUDENT_ID\r\n " + 
			"from games_history gh\r\n " + 
			"inner join games g on gh.game_id = g.game_id ", 
			  nativeQuery = true)
	public List<Prueba> buscar();
}
