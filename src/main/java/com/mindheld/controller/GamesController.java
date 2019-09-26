package com.mindheld.controller;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindheld.model.GameDTO;
import com.mindheld.model.GameHistoryDTO;
import com.mindheld.model.ResponseObject;
import com.mindheld.service.GameService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/games")
public class GamesController {

	@Autowired
	@Qualifier("gameService")
	private GameService gameService;

	private static final Log logger = LogFactory.getLog(GamesController.class);
	
	@GetMapping("/public/enabledgames")
	public ResponseEntity<?> getEnabledGames(){	
		ResponseObject response = new ResponseObject();
		try {
		response.setResult(gameService.getAllEnabled());
		response.setMessage(ResponseObject.OK_MESSAGE);
		response.setStatus(ResponseObject.OK);
		}catch (Exception e) {
			logger.error("Error on method getEnabledGames: \n" + e);
			response.setMessage("error getting enabled games");	
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllGames(){	
		ResponseObject response = new ResponseObject();
		try {
		response.setResult(gameService.findAll());
		response.setMessage(ResponseObject.OK_MESSAGE);
		response.setStatus(ResponseObject.OK);
		}catch (Exception e) {
			logger.error("Error on method getAllGames: \n" + e);
			response.setMessage("error getting all games");	
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/public/startPlaying")
	public ResponseEntity<?> startPlaying(@RequestBody GameHistoryDTO gameHistoryDTO){	
		ResponseObject response = new ResponseObject();
		try {
			gameHistoryDTO.setStartPlaying(new Timestamp(System.currentTimeMillis()));
			response.setResult(gameService.saveGameHistory(gameHistoryDTO));
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		}catch (Exception e) {
			logger.error("Error on method saveHistoryGame: \n" + e);
			response.setMessage("error saving history");	
			response.setStatus(ResponseObject.ERROR); 
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/public/endPlaying")
	public ResponseEntity<?> endPlaying(@RequestBody GameHistoryDTO gameHistoryDTO){	
		ResponseObject response = new ResponseObject();
		try {
			gameHistoryDTO.setEndPlaying(new Timestamp(System.currentTimeMillis()));
			response.setResult(gameService.saveGameHistory(gameHistoryDTO));
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		}catch (Exception e) {
			logger.error("Error on method saveHistoryGame: \n" + e);
			response.setMessage("error saving history");	
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/edit")
	public ResponseEntity<?> editGame(@RequestBody GameDTO gameDto){	
		ResponseObject response = new ResponseObject();
		try {
			gameService.edit(gameDto);
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		}catch (Exception e) {
			logger.error("Error on method saveHistoryGame: \n" + e);
			response.setMessage("error saving history");	
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	
}
