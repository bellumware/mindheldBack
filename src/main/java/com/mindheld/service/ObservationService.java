package com.mindheld.service;

import java.util.List;

import com.mindheld.model.ObservationsDTO;

public interface ObservationService {

	public void createObservation (ObservationsDTO observationDto);
	
	public void deleteObservation (ObservationsDTO observationDto);
	
	public boolean editObservation (ObservationsDTO observationDto);
	
	public List<ObservationsDTO> getObservationsByStudent(String studentId);
}
