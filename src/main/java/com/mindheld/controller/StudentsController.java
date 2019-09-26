package com.mindheld.controller;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindheld.model.ResponseObject;
import com.mindheld.model.StudentDTO;
import com.mindheld.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/students")
public class StudentsController {

	private static final Log logger = LogFactory.getLog(StudentsController.class);

	@Autowired
	@Qualifier("studentService")
	private StudentService studentService;

	@Autowired
	private ObservationController observationController;
	
	
	@GetMapping("/public/getAll/basic")
	public ResponseEntity<?> getAllStudentsBasic() {
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(studentService.findAllEnabledsBasic());
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method getAllStudentsBasic: \n" + e);
			response.setMessage("error getting students with basic information");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}

	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	@GetMapping("/getAll/basic")
	public ResponseEntity<?> getAllStudents() {
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(studentService.findAllBasic());
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method getAllStudents: \n" + e);
			response.setMessage("error getting all students");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}

	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<?> getStudent(@PathVariable String id) {
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(studentService.findStudentById(id));
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method getStudent: when trying to get student with id" + id + " \n" + e);
			response.setMessage("error getting student with id " + id);
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}

	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDto) {
		ResponseObject response = new ResponseObject();
		try {
			response.setResult(studentService.save(studentDto));
			observationController.createObservation(studentDto.getObservations().get(0));
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method saveStudent: \n" + e);
			response.setMessage("error saving student");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}

	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
	@PostMapping("/edit")
	public ResponseEntity<?> editStudent(@RequestBody StudentDTO studentDto) {
		ResponseObject response = new ResponseObject();
		try {
			if (studentService.edit(studentDto)) {
				observationController.createObservation(studentDto.getObservations().get(0));
				response.setResult(Boolean.TRUE);
				response.setMessage(ResponseObject.OK_MESSAGE);
				response.setStatus(ResponseObject.OK);
			}else {
				response.setResult(Boolean.FALSE);
				response.setMessage("non-existent id");
				response.setStatus(ResponseObject.ERROR);
			}
		} catch (Exception e) {
			logger.error("Error on method editStudent: \n" + e);
			response.setMessage("error editing student");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	

}
