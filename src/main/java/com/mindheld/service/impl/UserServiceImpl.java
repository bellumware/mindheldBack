package com.mindheld.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindheld.entity.User;
import com.mindheld.model.UserInformation;
import com.mindheld.repository.UserRepository;
import com.mindheld.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User userEntity = userRepository.findByUserName(username);
		User userEntity = userRepository.findByUserNameAndEnabled(username, Boolean.TRUE);
		if(userEntity == null) throw new UsernameNotFoundException("non-existent user");
		return buildUser(userEntity, buildAuthorities(userEntity));
	}
	
	private UserInformation buildUser(User userEntity, List<GrantedAuthority> authorities) {
		
		return new UserInformation(	userEntity.getUserName(), 
									userEntity.getPassword(), 
									userEntity.isEnabled(), 
									Boolean.TRUE, 
									Boolean.TRUE, 
									Boolean.TRUE, 
									authorities, 
									userEntity.getPerson().getPersonId());
	}

	private List<GrantedAuthority> buildAuthorities(User userEntity) {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority(userEntity.getRole().getRole()));
		return auths;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	

}
