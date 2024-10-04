
package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Courses;
import com.repository.CoursesRepository;

@Service
public class CoursesService {

	@Autowired
	CoursesRepository crepo;
	
	public List<Courses> getAll()
	{
		return crepo.findAll();
	}
	
	public String storeCourse(Courses c )
	{
		Optional<Courses> fc = crepo.findById(c.getCid());
		if(fc.isPresent())
			return "CID must be valid";
		else
		{
			crepo.save(c);
			return "Record saved successfully";
		}
	}
	
	public Courses getCoursebyId (int id)
	{
		return getAll().stream().filter(c -> c.getCid()==id).findFirst().get();
	}
	
}
