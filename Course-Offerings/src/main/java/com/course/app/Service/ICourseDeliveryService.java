package com.course.app.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.course.app.Entity.Course;
import com.course.app.Entity.Course_Delivery;

public interface ICourseDeliveryService {

	ResponseEntity<?> addCourseInstance(Long couseId, Course_Delivery coDeObj);

	ResponseEntity<List<Course_Delivery>> getCourseListByYearAndSem(int year, int sem);

	ResponseEntity<Course_Delivery> getInstanceDetailsByYearAndSemAndCourseId(int year, int sem, long courseId);

	void deleteCourseInstanceByYear_Sem_courseId(int year, int sem, long courseId);

	List<Course_Delivery> getAllInstanceList();

}
