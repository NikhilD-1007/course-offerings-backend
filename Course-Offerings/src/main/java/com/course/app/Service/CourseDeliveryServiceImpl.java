package com.course.app.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.course.app.Entity.Course;
import com.course.app.Entity.Course_Delivery;
import com.course.app.Exception.ResourceNotFoundException;
import com.course.app.Repository.CourseDeliveyRepository;
import com.course.app.Repository.CourseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseDeliveryServiceImpl implements ICourseDeliveryService{

	@Autowired
	private CourseDeliveyRepository courseDeliRepo;
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public ResponseEntity<?> addCourseInstance(Long courseId, Course_Delivery coDeObj) {
		// TODO Auto-generated method stub
		Course courseObj = courseRepo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Couse Details not found by Id "+courseId));
		
		coDeObj.setCourseObj(courseObj);
		
		Course_Delivery obj= courseDeliRepo.save(coDeObj);
		
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Course>> getCourseListByYearAndSem(int year, int sem) {
		// TODO Auto-generated method stub
		List<Course_Delivery> list = courseDeliRepo.findByYearOfDeliveryAndSemesterOfDelivery(year,sem);
		
		List<Course> courseList = new ArrayList<Course>();
		for(Course_Delivery i : list)
		{
			courseList.add(i.getCourseObj());
		}
		
		return new ResponseEntity<>(courseList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Course_Delivery> getInstanceDetailsByYearAndSemAndCourseId(int year, int sem, long courseId) {
		// TODO Auto-generated method stub
		Course courseDetail = courseRepo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Couse not found by Id "+courseId));
		
		Course_Delivery resCourseInstance = courseDeliRepo.findByYearOfDeliveryAndSemesterOfDeliveryAndCourseObj(year,sem,courseId).get();
		
		if(resCourseInstance !=null)
		{
			return new ResponseEntity<>(resCourseInstance,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	}

	@Override
	public void deleteCourseInstanceByYear_Sem_courseId(int year, int sem, long courseId) {
		// TODO Auto-generated method stub
		courseDeliRepo.deleteByYearOfDeliveryAndSemesterOfDeliveryAndCourseObj(year,sem,courseId);
		
	}
}
