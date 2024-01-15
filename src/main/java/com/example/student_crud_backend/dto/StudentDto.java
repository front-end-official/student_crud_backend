package com.example.student_crud_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	private Integer stuId;
	
	private String stuName;
	
	private String stuAge;
	
	private String stuSection;
	
	private Integer stuMarks;

}
