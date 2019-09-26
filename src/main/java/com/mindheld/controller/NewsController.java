package com.mindheld.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindheld.entity.New;
import com.mindheld.model.ResponseObject;
import com.mindheld.service.NewsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;
	

	private static final Log logger = LogFactory.getLog(NewsController.class);
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	@GetMapping("/getAll/{quantity}")
	public ResponseEntity<?> getAll(@PathVariable int quantity) {
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(newsService.getNews(quantity));
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method getAll news: \n" + e);
			response.setMessage("error getting news");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody New _new) {
		ResponseObject response = new ResponseObject();
		try {
			newsService.createNew(_new);
			response.setResult(Boolean.TRUE);
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method create news: \n" + e);
			response.setMessage("error creating news");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
}
