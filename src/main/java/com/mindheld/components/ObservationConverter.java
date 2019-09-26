package com.mindheld.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mindheld.entity.Observation;
import com.mindheld.model.ObservationsDTO;
import com.mindheld.service.StudentService;
import com.mindheld.service.UserService;

@Component("observationConverter")
public class ObservationConverter {

	@Autowired
	@Qualifier("fileHandler")
	private FileHandler fileHandler;

	@Autowired
	@Qualifier("studentService")
	private StudentService studentService;

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	public Observation observationDTOToEntity(ObservationsDTO observationDto) {
		var _return = new Observation();
		_return.setObservation(observationDto.getObservation());
		_return.setSupportFile(fileHandler.stringBase64ToFile(observationDto.getSupportFile()));
		_return.setObservationDate(observationDto.getObservationDate());
		_return.setStudent(studentService.findStudentEntityById(observationDto.getStudentId()));
		_return.setUser(userService.findByUserName(observationDto.getUserName()));
		_return.setObservationId(observationDto.getObservationId());
		_return.setEnabled(observationDto.isEnabled());
		return _return;

	}

	public ObservationsDTO observationEntityToDTO(Observation observation) {
		var _return = new ObservationsDTO();
		_return.setObservation(observation.getObservation());
		_return.setSupportFile(observation.getSupportFile());
		_return.setObservationDate(observation.getObservationDate());
		_return.setStudentId(observation.getStudent().getStudentId());
		_return.setUserName(observation.getUser().getUserName());
		_return.setObservationId(observation.getObservationId());
		_return.setEnabled(observation.isEnabled());
		return _return;
	}
	
	public List<ObservationsDTO> ListEntitysToDtos(List<Observation> observations){
		var _return = new ArrayList<ObservationsDTO>();
		observations.forEach(observation -> _return.add(observationEntityToDTO(observation)));
		return _return;
	}
}
