package com.mindheld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mindheld.entity.Person;
import com.mindheld.entity.Photo;
import com.mindheld.entity.Student;
import com.mindheld.model.PhotoDTO;
import com.mindheld.repository.PhotoRepository;
import com.mindheld.service.PhotoService;

@Service("photoService")
public class PhotoImpl implements PhotoService{
	
	@Autowired
	@Qualifier("photoRepository")
	private PhotoRepository photoRepository;

	@Override
	public String findPhotoById(long photoId) {
		return photoRepository.findByPhotoId(photoId).getPath();
	}

	@Override
	public Photo save(PhotoDTO photoDto) {
		var photo = new Photo();
		photo.setPath(photoDto.getPhotoPath());
		photo.setPerson(photoDto.getPerson());
		photo.setStudent(photoDto.getStudent());
		return photoRepository.save(photo);		
	}
	

	@Override
	public Photo save(Photo photo) {
		return photoRepository.save(photo);		
	}

	@Override
	public Photo edit(Photo photo) {
		var entity = photoRepository.findByPersonAndStudent(photo.getPerson(), photo.getStudent());
		if(entity != null) {
			entity.setPath(photo.getPath());
			return save(entity);
		}else return save(photo);
	}

	
	@Override
	public Photo findByPhotoPersonIdAndStudentId(Person person, Student student) {
		return photoRepository.findByPersonAndStudent(person, student);
	}

	@Override
	public void delete(String photoPath) {
//		var photo = photoRepository.findByPath(photoPath);
	}

	
}
