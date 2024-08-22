package com.course.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.app.Entity.Course;
import com.course.app.Entity.Course_Delivery;
import com.course.app.Service.ICourseDeliveryService;
import com.course.app.Service.ICourseService;

@RestController
@RequestMapping("/api/instances")
@CrossOrigin("*")
public class CourseContentDeliveryController {

	@Autowired
	private ICourseDeliveryService courseDeliveryService;
	
	
	@GetMapping
	List<Course_Delivery> getAllInstances()
	{
		return courseDeliveryService.getAllInstanceList();
	}
	
	@PostMapping("/{couseId}")
	ResponseEntity<?> addNewCourseInstance(@PathVariable Long couseId, @RequestBody Course_Delivery coDeObj )
	{
		return courseDeliveryService.addCourseInstance(couseId,coDeObj);
	}
	
	@GetMapping("/{year}/{sem}")
	ResponseEntity<List<Course_Delivery>> getAllCourses(@PathVariable int year,@PathVariable int sem)
	{
		return courseDeliveryService.getCourseListByYearAndSem(year, sem);
	}
	
	@GetMapping("/{year}/{sem}/{courseId}")
	ResponseEntity<Course_Delivery> getInstanceDetailes(@PathVariable int year,@PathVariable int sem,@PathVariable long courseId)
	{
		return courseDeliveryService.getInstanceDetailsByYearAndSemAndCourseId(year, sem,courseId);
	}
	
	@DeleteMapping("/{year}/{sem}/{courseId}")
	ResponseEntity<?> deleteCourseInstance(@PathVariable int year,@PathVariable int sem,@PathVariable long courseId)
	{
		courseDeliveryService.deleteCourseInstanceByYear_Sem_courseId(year, sem,courseId);
		return new ResponseEntity<>("Instance Deleted", HttpStatus.OK);
	}
	
}
