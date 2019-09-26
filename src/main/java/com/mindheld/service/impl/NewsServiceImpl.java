package com.mindheld.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mindheld.entity.New;
import com.mindheld.repository.NewsRepository;
import com.mindheld.service.NewsService;


@Service("newsService")
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsRepository newsRepository;
	
	@Override
	public void createNew(New _new) {
		_new.setNewDate(new Timestamp(System.currentTimeMillis()));
		newsRepository.save(_new);
	}

	@Override
	public List<New> getNews(int quantity) {
		if(quantity == 0) {
			return newsRepository.findAll(Sort.by(Sort.Direction.DESC, "newDate"));
		}else {
			return newsRepository.findAll(PageRequest.of(0, quantity, Sort.by(Sort.Direction.DESC, "newDate"))).getContent();
		}
	}

}
