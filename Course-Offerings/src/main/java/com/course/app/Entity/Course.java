package com.course.app.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="coursemaster")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "courseObj",cascade = CascadeType.ALL)
	private List<Course_Delivery> courseDeliveryList;
}
