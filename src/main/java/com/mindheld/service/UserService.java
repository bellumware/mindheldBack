package com.mindheld.service;

import java.util.List;
import com.mindheld.entity.User;

public interface UserService {

	public List<User> findAll();	
	public User save(User user);
	public User findByUserName(String userName);
	public void delete(User user);
}
