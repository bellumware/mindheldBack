package com.mindheld.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
	
	public User findByUserName(String userName);

	public User findByUserNameAndEnabled(String userName, boolean enabled);
}
