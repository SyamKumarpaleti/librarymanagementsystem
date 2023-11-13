package com.springboot.main.library.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Book;
import com.springboot.main.library.model.Student;
import com.springboot.main.library.model.StudentBook;
import com.springboot.main.library.service.BookService;
import com.springboot.main.library.service.StudentBookService;
import com.springboot.main.library.service.StudentService;

@RestController
public class StudentBookController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private BookService bookService;
	@Autowired
	private StudentBookService studentBookService;
	
	
	
	@PostMapping("/student/book/{sid}/{bid}")
	public ResponseEntity<?> bookTicket(@PathVariable("sid") int sid, @PathVariable("bid") int bid,
			@RequestBody StudentBook studentBook) {

		try {
			Student student = studentService.getStudent(sid);
			Book book = bookService.getById(bid);
			studentBook.setStudent(student);
			studentBook.setBook(book);
			studentBook.setIssueDate(LocalDate.now());
			studentBook = studentBookService.insert(studentBook);
			return ResponseEntity.ok().body(studentBook);

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@GetMapping("/book/status/{sid}") // get your book status
	public ResponseEntity<?> getBookStatus(@PathVariable("sid") int sid) {

		try {
			Student student = studentService.getStudent(sid);
			List<StudentBook> list = studentBookService.getBookStatus(sid);
			return ResponseEntity.ok().body(list);

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}


}
