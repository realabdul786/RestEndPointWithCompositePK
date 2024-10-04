
package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Students;
import com.repository.StudentsRepository;


@Service
public class StudentsService {

	
	@Autowired
	StudentsRepository srepo;
	
	public List<Students> findAll()
	{
		return srepo.findAll();
	}
	
	public String storeStudent(Students s)
	{
		Optional<Students> fetchedStudent = srepo.findById(s.getSid());
		if(fetchedStudent.isPresent())
			return "SID must be unique";
		else
		{
			srepo.save(s);
			return "record Saved successfully";
		}
	}
	
	public Students getStudById(int id)
	{
		return findAll().stream().filter(s -> s.getSid()==id).findFirst().get();
	}
	
}
