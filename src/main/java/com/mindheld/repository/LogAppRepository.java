package com.mindheld.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.LogApplication;

@Repository("logAppRepository")
public interface LogAppRepository extends JpaRepository<LogApplication, Serializable> {

}
