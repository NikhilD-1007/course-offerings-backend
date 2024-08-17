package com.course.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.app.Entity.Course;
import com.course.app.Entity.Course_Delivery;

@Repository
public interface CourseDeliveyRepository extends JpaRepository<Course_Delivery, Long>{

	List<Course_Delivery> findByYearOfDeliveryAndSemesterOfDelivery(int year, int sem);

}
