package com.mindheld.service;

import java.util.List;

import com.mindheld.entity.New;

public interface NewsService {

	public void createNew(New _new);
	
	public List<New> getNews(int quantity);
	
}
