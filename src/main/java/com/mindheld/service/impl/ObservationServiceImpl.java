package com.mindheld.service.impl;

import static com.mindheld.constants.Constants.ADMIN;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mindheld.components.ObservationConverter;
import com.mindheld.model.ObservationsDTO;
import com.mindheld.repository.ObservationRepository;
import com.mindheld.service.ObservationService;
import com.mindheld.service.StudentService;
import com.mindheld.util.Utils;

@Service("observationService")
public class ObservationServiceImpl implements ObservationService {

	@Autowired
	@Qualifier("observationRepository")
	private ObservationRepository observationRepository;

	@Autowired
	@Qualifier("observationConverter")
	private ObservationConverter observationConverter;
	
	@Autowired
	@Qualifier("studentService")
	private StudentService studentService;

	@Override
	public void createObservation(ObservationsDTO observationDto) {
		if(Utils.isValidString(observationDto.getObservation())) {
			observationDto.setEnabled(Boolean.TRUE);
			observationDto.setObservationDate(new Date());
			observationDto.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
			observationRepository.save(observationConverter.observationDTOToEntity(observationDto));
		}
	}

	@Override
	public void deleteObservation(ObservationsDTO observationDto) {
		var observation = observationRepository.findByObservationId(observationDto.getObservationId());
		if (observation != null) {
			observation.setEnabled(Boolean.FALSE);
			observationRepository.save(observation);
		}
	}

	@Override
	public boolean editObservation(ObservationsDTO observationDto) {
		var observation = observationRepository.findByObservationId(observationDto.getObservationId());
		if (observation != null) {
			observationRepository.save(observationConverter.observationDTOToEntity(observationDto));
			return true;
		}
		return false;
	}

	@Override
	public List<ObservationsDTO> getObservationsByStudent(String studentId) {
		var authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if (!authorities.stream().filter(x -> x.getAuthority().equals(ADMIN)).collect(Collectors.toList()).isEmpty()) {
			var entities = observationRepository.findByStudent(studentService.findStudentEntityById(studentId), Sort.by(Sort.Direction.DESC, "observationDate"));
			return observationConverter.ListEntitysToDtos(entities);
		} else {
			var entities = observationRepository.findByStudentAndEnabled(studentService.findStudentEntityById(studentId), Boolean.TRUE, Sort.by(Sort.Direction.DESC, "observationDate"));
			return observationConverter.ListEntitysToDtos(entities);
		}
	}

}
