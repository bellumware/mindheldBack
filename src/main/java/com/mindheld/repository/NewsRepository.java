package com.mindheld.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mindheld.entity.New;

@Repository("newsRepository")
public interface NewsRepository extends JpaRepository<New, Serializable>{
	
}
