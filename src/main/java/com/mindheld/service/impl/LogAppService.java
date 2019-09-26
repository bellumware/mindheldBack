package com.mindheld.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mindheld.entity.LogApplication;
import com.mindheld.repository.LogAppRepository;

@Service("logAppService")
public class LogAppService {

	
	@Autowired
	@Qualifier("logAppRepository")
	private LogAppRepository logAppRepository;
	
	
	public void saveLog(String action) {
		var logApplication = new LogApplication();
		logApplication.setAction(action);
		logApplication.setLogDate(new Timestamp(System.currentTimeMillis()));
		logApplication.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		logAppRepository.save(logApplication);
	}
}
