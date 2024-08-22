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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.app.Entity.Course;
import com.course.app.Service.ICourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseController {

	@Autowired
	private ICourseService courseService;
	
	
	@PostMapping
	ResponseEntity<?> addNewCourse(@RequestBody Course courseObj)
	{
		return courseService.addCourseDetails(courseObj);
	}
	
	@GetMapping
	List<Course> getAllCourses()
	{
		return courseService.getAllCourseList();
	}
	
	@GetMapping("/{couseId}")
	ResponseEntity<?> getCourseDetailsById(@PathVariable Long couseId)
	{
		return courseService.getCourseById(couseId);
	}
	
	@DeleteMapping("/{couseId}")
	ResponseEntity<?> deleteCourseById(@PathVariable Long couseId)
	{
		courseService.deleteCourseById(couseId);
		return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
	}
}
