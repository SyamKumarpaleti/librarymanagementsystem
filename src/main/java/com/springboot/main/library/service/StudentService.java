package com.springboot.main.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Student;
import com.springboot.main.library.repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student insert(Student student) {
		
		return studentRepository.save(student);
	}
	public  Student getOne(int id) throws InvalidIdException {
		Optional<Student> optional=studentRepository.findById(id);
		if(!optional.isPresent()){
			throw new InvalidIdException("Student ID Invalid");
		}
		return optional.get();
	}
	

	public List<Student> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return studentRepository.findAll(pageable).getContent();
	}

	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}

	public Student postStudent(Student student) {
		
		return studentRepository.save(student);
	}
	public Student getStudent(int sid) throws InvalidIdException {
		Optional<Student> optional = studentRepository.findById(sid);
		if (!optional.isPresent()) {
			throw new InvalidIdException("Student Id invalid");
		}
		return optional.get();

	}
		
}