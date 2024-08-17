package com.course.app.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="course_delivery_master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course_Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_delivery_Id")
	private Long courseDeliveryId;
	
	@Column(name = "delivery_year")
	private int yearOfDelivery;
	
	@Column(name = "delivery_semester")
	private int semesterOfDelivery;
	
	@ManyToOne
	@JoinColumn(name = "couse_id")
	private Course courseObj;
	
	
}
