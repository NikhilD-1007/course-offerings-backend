package com.course.app.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.course.app.Entity.Course_Delivery;

@Repository
public interface CourseDeliveyRepository extends JpaRepository<Course_Delivery, Long>{

	List<Course_Delivery> findByYearOfDeliveryAndSemesterOfDelivery(int year, int sem);


	@Query("SELECT i FROM Course_Delivery i WHERE i.yearOfDelivery = ?1 AND i.semesterOfDelivery = ?2 AND i.courseObj.courseId = ?3")
	Optional<Course_Delivery> findByYearOfDeliveryAndSemesterOfDeliveryAndCourseObj(int year, int sem, long courseId);


	@Modifying
	@Query("DELETE FROM Course_Delivery i WHERE i.yearOfDelivery = ?1 AND i.semesterOfDelivery = ?2 AND i.courseObj.courseId = ?3")
	void deleteByYearOfDeliveryAndSemesterOfDeliveryAndCourseObj(int year, int sem, long courseId);

}
