package com.example.student_crud_backend.service;

import java.util.List;

import com.example.student_crud_backend.dto.StudentDto;

public interface StudentService {
	
	public StudentDto add(StudentDto dto);
	
	public StudentDto update(StudentDto dto);
	
	public List<StudentDto> get();
	
	public String delete(Integer id);
	
	public StudentDto getOne(Integer id);
	
	public StudentDto updateWithId(Integer id,StudentDto dto);

}
