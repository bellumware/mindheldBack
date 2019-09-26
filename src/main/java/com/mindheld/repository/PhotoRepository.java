package com.mindheld.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindheld.entity.Person;
import com.mindheld.entity.Photo;
import com.mindheld.entity.Student;

@Repository("photoRepository")
public interface PhotoRepository extends JpaRepository<Photo, Serializable> {

	public Photo findByPath(String path);
	public Photo findByPhotoId(long photoId);
	public Photo findByPersonAndStudent(Person person, Student student);
}
