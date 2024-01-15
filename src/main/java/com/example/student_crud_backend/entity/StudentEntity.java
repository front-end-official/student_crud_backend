package com.example.student_crud_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="STUDENT-CRUD-BACKEND")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STUDENT-ID")
	private Integer id;
	
	@Column(name="STUDENT-NAME")
	private String name;
	
	@Column(name="STUDENT-AGE")
	private String age;
	
	@Column(name="STUDENT-SECTION")
	private String section;
	
	@Column(name="STUDENT-MARKS")
	private Integer marks;

}
