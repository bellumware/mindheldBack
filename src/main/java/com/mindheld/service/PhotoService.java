package com.mindheld.service;

import com.mindheld.entity.Person;
import com.mindheld.entity.Photo;
import com.mindheld.entity.Student;
import com.mindheld.model.PhotoDTO;

public interface PhotoService {

	public String findPhotoById(long photoId);
	public Photo save (PhotoDTO photoDto);
	public Photo save (Photo photo);
	public Photo edit(Photo photo);
	public Photo findByPhotoPersonIdAndStudentId(Person person, Student student);
    public void delete(String photoPath);
    
}
