package com.springboot.main.library.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Admin;
import com.springboot.main.library.model.Book;
import com.springboot.main.library.service.AdminService;
import com.springboot.main.library.service.BookService;



@RestController
@RequestMapping("/Book")
public class BookController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private BookService bookService;
	@PostMapping("/add/{id}")
	public ResponseEntity<?> postBook(@RequestBody Book book, 
						    @PathVariable("id") int id) {
			/* Fetch vendor object from db using id */
		try {
			Admin admin = adminService.getOne(id);
			/* Attach vendor to product */
			book.setAdmin(admin);
			/* Save the product in the DB */
			book = bookService.postBook(book);
			return ResponseEntity.ok().body(book);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@GetMapping("/all")
	public List<Book> getAllProducts(
			@RequestParam(value="page",required = false,defaultValue = "0") Integer page,
			@RequestParam(value="size",required = false,defaultValue = "1000000") Integer size) {  /*product=book,vendor =admin */
		
		Pageable pageable =  PageRequest.of(page, size);
		return bookService.getAllBook(pageable);
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<?> getbookByAdmin(@PathVariable("id") int id) {
		/* Fetch vendor object using given id */
		try {
			Admin admin = adminService.getOne(id);
			List<Book> list= bookService.getbookByAdmin(id);
			return ResponseEntity.ok().body(list);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}

}
