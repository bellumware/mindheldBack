package com.mindheld.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindheld.model.ObservationsDTO;
import com.mindheld.model.ResponseObject;
import com.mindheld.service.ObservationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/observation")
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TEACHER')")
public class ObservationController {

	private static final Log logger = LogFactory.getLog(ObservationController.class);

	@Autowired
	@Qualifier("observationService")
	private ObservationService observationService;

	@PostMapping("/create")
	public ResponseEntity<?> createObservation(@RequestBody ObservationsDTO observationDto) {
		ResponseObject response = new ResponseObject();
		try {
			observationService.createObservation(observationDto);
			response.setResult(Boolean.TRUE);
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method createObservation: \n" + e);
			response.setMessage("error creating observation");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping("/edit")
	public ResponseEntity<?> editObservation(@RequestBody ObservationsDTO observationDto) {
		ResponseObject response = new ResponseObject();
		try {
			if (observationService.editObservation(observationDto)) {
				response.setResult(Boolean.TRUE);
				response.setMessage(ResponseObject.OK_MESSAGE);
				response.setStatus(ResponseObject.OK);
			}else {
				response.setResult(Boolean.FALSE);
				response.setMessage("non-existent id");
				response.setStatus(ResponseObject.ERROR);
			}
		} catch (Exception e) {
			logger.error("Error on method editObservation: \n" + e);
			response.setMessage("error editing observation");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteObservation(@RequestBody ObservationsDTO observationDto) {
		ResponseObject response = new ResponseObject();
		try {
			observationService.deleteObservation(observationDto);
			response.setResult(Boolean.TRUE);
			response.setMessage(ResponseObject.OK_MESSAGE);
			response.setStatus(ResponseObject.OK);
		} catch (Exception e) {
			logger.error("Error on method createObservation: \n" + e);
			response.setMessage("error creating observation");
			response.setStatus(ResponseObject.ERROR);
		}
		return ResponseEntity.ok(response);
	}

}
