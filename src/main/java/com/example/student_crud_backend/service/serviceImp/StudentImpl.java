package com.example.student_crud_backend.service.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.student_crud_backend.dto.StudentDto;
import com.example.student_crud_backend.entity.StudentEntity;
import com.example.student_crud_backend.repo.StudentRepository;
import com.example.student_crud_backend.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentImpl implements StudentService{
	
	
	private final StudentRepository repository;

	@Override
	public StudentDto add(StudentDto dto) {
		StudentEntity entity = converDtoToEntity(dto);
		StudentEntity saveedEntity = repository.save(entity);
		StudentDto convertedDto = converEntityToDto(saveedEntity);
		return convertedDto;
//		return converEntityToDto(repository.save(converDtoToEntity(dto)));
	}

	@Override
	public StudentDto update(StudentDto dto) {
		Optional<StudentEntity> findById = repository.findById(dto.getStuId());
		if(findById.isPresent())
		{
			System.out.println(dto);
			StudentEntity ent = converDtoToEntity(dto);
			ent.setId(dto.getStuId());
			repository.save(ent);
			return converEntityToDto(ent);
		}
		return null;
	}
	@Override
	public StudentDto updateWithId(Integer id,StudentDto dto) {
		Optional<StudentEntity> findById = repository.findById(id);
		if(findById.isPresent())
		{
			System.out.println(dto);
			StudentEntity ent = converDtoToEntity(dto);
			ent.setId(id);
			repository.save(ent);
			return converEntityToDto(ent);
		}
		return null;
	}
	@Override
	public List<StudentDto> get() {
		List<StudentEntity> findAll = repository.findAll(); //Static Line (IT WILL ALWAYS BE THERE)
		
		
		//WITH FOREACH 
		
		List<StudentDto> dtos = new ArrayList<>();
		
		for (StudentEntity studentEntity : findAll) {
			dtos.add(converEntityToDto(studentEntity));
		}
		return dtos;
		
//		List<StudentDto> list = findAll.stream().map(i->converEntityToDto(i)).toList();
//		
//		return list;
	}

	@Override
	public String delete(Integer id) {
		Optional<StudentEntity> findById = repository.findById(id);
		if(findById.isPresent()) {
			repository.deleteById(id);
			return "Deleted..";
		}
		return "Id Not Found !!!";
	}

	@Override
	public StudentDto getOne(Integer id) {
		 Optional<StudentEntity> findById = repository.findById(id);
		 if(findById.isPresent()) {
			 StudentEntity studentEntity = findById.get();
			 StudentDto converEntityToDto = converEntityToDto(studentEntity);
			 return converEntityToDto;
		 }
		 return null;
	}
	
	private StudentEntity converDtoToEntity(StudentDto dto)
	{
		return StudentEntity.builder()
				.name(dto.getStuName())
				.age(dto.getStuAge())
				.marks(dto.getStuMarks())
				.section(dto.getStuSection())
				.build();
	}
	
	private StudentDto converEntityToDto(StudentEntity entity)
	{
		StudentDto dto=new StudentDto();
		dto.setStuName(entity.getName());
		dto.setStuAge(entity.getAge());
		dto.setStuMarks(entity.getMarks());
		dto.setStuSection(entity.getSection());
		dto.setStuId(entity.getId());
		return dto;
		
	}

}
