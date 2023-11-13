package com.springboot.main.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.library.model.StudentBook;
import com.springboot.main.library.repository.StudentBookRepository;

@Service
public class StudentBookService {
	@Autowired
	private StudentBookRepository studentBookRepository;

	public StudentBook insert(StudentBook studentBook) {
		
		return studentBookRepository.save(studentBook);
	}

	public List<StudentBook> getBookStatus(int sid) {
		
		return studentBookRepository.getMyBookStatus(sid);
	}

}
