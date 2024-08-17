package com.course.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.app.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
