package com.example.student_crud_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_crud_backend.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}
