package com.mindheld.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mindheld.components.FileHandler;
import com.mindheld.components.PersonConverter;
import com.mindheld.constants.Constants;
import com.mindheld.entity.Person;
import com.mindheld.entity.Student;
import com.mindheld.model.StudentBasicDTO;
import com.mindheld.model.StudentDTO;
import com.mindheld.repository.StudentRepository;
import com.mindheld.service.PersonService;
import com.mindheld.service.PhotoService;
import com.mindheld.service.StudentService;
import com.mindheld.util.Utils;

@Service("studentService")
public class StudentServiceImpl extends LogAppService implements StudentService {

	@Autowired
	@Qualifier("studentRepository")
	private StudentRepository studentRepository;

	@Autowired
	@Qualifier("personConverter")
	private PersonConverter personConverter;

	@Autowired
	@Qualifier("personService")
	private PersonService personService;

	@Autowired
	@Qualifier("fileHandler")
	private FileHandler fileHandler;

	@Autowired
	@Qualifier("photoService")
	private PhotoService photoService;

	@Override
	public List<StudentBasicDTO> findAllBasic() {
		var students = studentRepository.findAll();
		return personConverter.convertTobasicDTO(students);
	}

	@Override
	public List<StudentBasicDTO> findAllEnabledsBasic() {
		var students = studentRepository.findByEnabled(Boolean.TRUE);
		return personConverter.convertTobasicDTO(students);
	}

	@Override
	public StudentDTO findStudentById(String studentId) {
		saveLog("find student by Id: " + studentId);
		var student = studentRepository.findByStudentId(studentId);
		return personConverter.entityToStudentDTO(student);
	}
	
	

	@Override
	public Student findStudentEntityById(String studentId) {
		return studentRepository.findByStudentId(studentId);
	}

	@Override
	public StudentDTO save(StudentDTO studentDto) {
		
		var entity = personConverter.studentDtoToEntity(studentDto);
		var persons = new ArrayList<Person>();
		studentDto.getParents().forEach(parent -> persons.add(personConverter.personDtoToEntity(parent)));
		persons.forEach(person -> personService.save(person));
		entity.setPersons(persons);
		studentRepository.save(entity);
		if (Utils.isValidString(studentDto.getStudent().getPhoto()) && !studentDto.getStudent().getPhoto().startsWith(Constants.PHOTOS_URL)) {
			var photo = photoService.findByPhotoPersonIdAndStudentId(null, entity);
			fileHandler.deleteImg(photo);
			photo = fileHandler.stringBase64ToPhoto(studentDto.getStudent().getPhoto());
			photo.setStudent(entity);
			photoService.edit(photo);
			studentDto.getStudent().setPhoto(photo.getPath());
		}
		return studentDto;
	}

	@Override
	public boolean edit(StudentDTO student) {
		if (findStudentById(student.getStudent().getPersonId()) != null) {
			save(student);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public void delete(String studentId) {
		saveLog("Disabling student by id " + studentId);
		var student = studentRepository.findByStudentId(studentId);
		student.setEnabled(Boolean.FALSE);
		studentRepository.save(student);

	}

}
