package com.example.student_crud_backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_crud_backend.dto.StudentDto;
import com.example.student_crud_backend.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stu")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentController {
	
	 private final StudentService service;
	 
	 @GetMapping("/all")
	 public ResponseEntity<List<StudentDto>> getAllStudents()
	 {
		 return new ResponseEntity<>(service.get(),HttpStatus.OK);
	 }
	 @PostMapping("/add")
	 public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto dto){
		 return new ResponseEntity<StudentDto>(service.add(dto),HttpStatus.OK);
	 }
	 
	 @DeleteMapping	("/delete/{id}")
	 public ResponseEntity<Map<Integer, String>> delete(@PathVariable Integer id){
		 Map<Integer, String> del=new HashMap<>();
		 del.put(id,service.delete(id));
		 return new ResponseEntity<Map<Integer, String>>(del,HttpStatus.OK);
	 }
	 
	 @PutMapping("/update2")
	 public ResponseEntity<StudentDto> update(@RequestBody StudentDto dto){
		 return new ResponseEntity<StudentDto>(service.update(dto),HttpStatus.OK);
	 }
	 @PutMapping("/update/{id}")
	 public ResponseEntity<StudentDto> updateWithId(@PathVariable Integer id,@RequestBody StudentDto dto){
		 return new ResponseEntity<StudentDto>(service.updateWithId(id,dto),HttpStatus.OK);
	 }
	 @GetMapping("/one/{id}")
	 public ResponseEntity<StudentDto> one(@PathVariable Integer id) {
	     // Your method logic here
	     return new ResponseEntity<StudentDto>(service.getOne(id), HttpStatus.OK);
	 }
}
