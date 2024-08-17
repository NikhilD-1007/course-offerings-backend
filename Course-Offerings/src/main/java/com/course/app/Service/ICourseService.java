package com.course.app.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.course.app.Entity.Course;

public interface ICourseService {

	ResponseEntity<?> addCourseDetails(Course courseObj);

	List<Course> getAllCourseList();

	ResponseEntity<?> getCourseById(Long couseId);

	void deleteCourseById(Long couseId);

}
