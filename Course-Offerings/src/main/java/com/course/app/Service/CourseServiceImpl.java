package com.course.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.course.app.Entity.Course;
import com.course.app.Exception.ResourceNotFoundException;
import com.course.app.Repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public ResponseEntity<?> addCourseDetails(Course courseObj) {
		// TODO Auto-generated method stub
		Course added= courseRepo.save(courseObj);
		return new ResponseEntity<>(added,HttpStatus.CREATED);
	}

	@Override
	public List<Course> getAllCourseList() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public ResponseEntity<?> getCourseById(Long couseId) {
		// TODO Auto-generated method stub
		Course courseDet = courseRepo.findById(couseId).orElseThrow(()-> new ResourceNotFoundException("Couse Details not found by Id "+couseId));
		
		return new ResponseEntity<>(courseDet,HttpStatus.OK);
	}

	@Override
	public void deleteCourseById(Long couseId) {
		// TODO Auto-generated method stub
		courseRepo.deleteById(couseId);

	}
}
