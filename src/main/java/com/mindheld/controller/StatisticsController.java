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

import com.mindheld.entity.GameResult;
import com.mindheld.model.ResponseObject;
import com.mindheld.service.StatisticsService;
import com.mindheld.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	

	private static final Log logger = LogFactory.getLog(StatisticsController.class);
	
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/studentsCreatedStatistic")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	public ResponseEntity<?> studentsCreatedStatistic(){
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(statisticsService.getStudentsCreateStatistic());
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method studentsCreatedStatistic: \n" + e);
			response.setMessage("error getting studentsCreatedStatistic");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);		
	}
	
	@GetMapping("/studentsEnabledStatistic")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	public ResponseEntity<?> studentsEnabledStatistic(){
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(statisticsService.getStudentsEnabledtistic());
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method studentsEnabledStatistic: \n" + e);
			response.setMessage("error getting studentsEnabledStatistic");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);		
	}
	
	@GetMapping("/gamesEnabledStatistic")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	public ResponseEntity<?> gamesEnabledStatistic(){
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(statisticsService.getGamesEnabledtistic());
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method gamesEnabledStatistic: \n" + e);
			response.setMessage("error getting gamesEnabledStatistic");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);		
	}

	@GetMapping("/gamesStatistic/{studentId}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	public ResponseEntity<?> gamesStatisticsByStudent(@PathVariable String studentId){
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(statisticsService.getGamesStatisticsByStudent(studentId));
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method gamesStatisticsByStudent: \n" + e);
			response.setMessage("error getting gamesStatisticsByStudent");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);		
	}
	
	@GetMapping("/observationStatistic/{studentId}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	public ResponseEntity<?> observationStatisticsByStudent(@PathVariable String studentId){
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(statisticsService.getObservationStatisticByStudent(studentId));
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method observationStatisticsByStudent: \n" + e);
			response.setMessage("error getting observationStatisticsByStudent");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);		
	}
	
	@GetMapping("/gameResults/{studentId}")
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	public ResponseEntity<?> gameResultsByStudent(@PathVariable String studentId){
		ResponseObject response = new ResponseObject();
		try {
			var student = studentService.findStudentEntityById(studentId);
			response.setResult(statisticsService.getGameResultsByStudent(student));
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method gameResultsByStudent: \n" + e);
			response.setMessage("error getting gameResultsByStudent");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);		
	}
	
	@PostMapping("/public/saveStatistic")
	public ResponseEntity<?> saveResults(@RequestBody GameResult gameResult){
		ResponseObject response = new ResponseObject();
		try {
			statisticsService.saveResult(gameResult);
			response.setResult("ok");
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method saveResults: \n" + e);
			response.setMessage("error getting saveResults");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);	
	}
}
