
package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Courses;
import com.entity.Enrollment;
import com.entity.Students;
import com.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	EnrollmentRepository erepo;
	
	@Autowired
	CoursesService cs;
	
	@Autowired
	StudentsService ss;
	
	public List<Enrollment> getAll()
	{
		return erepo.findAll();
	}
	
	public String enroll(Enrollment e)
	{
		Optional<Enrollment > fe = erepo.findById(e.getEk());
		if(fe.isPresent())
			return "Course already enrolled";
		else
		{
			Courses c = cs.getCoursebyId(e.getEk().getCid());
			e.setCourse(c);
			
			Students s = ss.getStudById(e.getEk().getSid());
			e.setStudent(s);
			erepo.save(e);
			return "Course enrolled successfully";
		}
	}
}
