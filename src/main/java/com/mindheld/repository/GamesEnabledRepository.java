package com.mindheld.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.GamesEnabled;

@Repository("gamesEnabledRepository")
public interface GamesEnabledRepository extends JpaRepository<GamesEnabled, Serializable> {

}
