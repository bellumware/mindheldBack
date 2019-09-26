package com.mindheld.controller;

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

import com.mindheld.entity.Person;
import com.mindheld.model.ResponseObject;
import com.mindheld.service.TeacherService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/teacher")
public class TeacherController {


	private static final Log logger = LogFactory.getLog(StudentsController.class);
	
	@Autowired
	@Qualifier("teacherService")
	private TeacherService teacherService;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllTeachers() {
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(teacherService.findTeachers());
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method getAllTeachers: \n" + e);
			response.setMessage("error getting Teachers");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> createTeacher(@RequestBody Person person) {
		ResponseObject response = new ResponseObject();
		try {
			teacherService.createTeacher(person);
			response.setResult("teacher created succesfully");
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method createTeacher: \n" + e);
			response.setMessage("error creating teacher");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/edit")
	public ResponseEntity<?> editTeacher(@RequestBody Person person) {
		ResponseObject response = new ResponseObject();
		try {
			teacherService.editTeacher(person);
			response.setResult("teacher edited succesfully");
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method editTeacher: \n" + e);
			response.setMessage("error editing teacher");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/delete")
	public ResponseEntity<?> deleteTeacher(@RequestBody Person person) {
		ResponseObject response = new ResponseObject();
		try {
			teacherService.deleteTeacher(person);
			response.setResult("teacher deleted succesfully");
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method deleteTeacher: \n" + e);
			response.setMessage("error deleting teacher");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
}
