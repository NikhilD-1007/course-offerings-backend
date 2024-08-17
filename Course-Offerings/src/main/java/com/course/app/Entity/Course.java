package com.course.app.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="coursemaster")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_Id")
	private Long courseId;
	
	@Column(name = "course_title", nullable = false)
	private String courseTitle;
	
	@Column(name = "course_code", nullable = false)
	private String courseCode;
	
	@Column(name = "course_description", nullable = false)
	private String courseDesc;
	
}
