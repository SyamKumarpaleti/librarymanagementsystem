package com.springboot.main.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.dto.BookDto;
import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Book;
import com.springboot.main.library.model.Vendor;
import com.springboot.main.library.service.BookService;
import com.springboot.main.library.service.VendorService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private VendorService vendorService;
	@Autowired
	private BookService bookService;
	

	@PostMapping("/post/{vid}")
	public ResponseEntity<?> postBook(@RequestBody Book book,@PathVariable("vid") int vid) {
		try {
			Vendor vendor = vendorService.getById(vid);
			book.setVendor(vendor);
			book=bookService.insert(book);
			return ResponseEntity.ok().body(book);
			
		}	catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
				
		}
	}
	@GetMapping("/all")
	public List<Book> getAllBooks(
			@RequestParam(value="page",required = false,defaultValue = "0") Integer page,
			@RequestParam(value="size",required = false,defaultValue = "1000000") Integer size) {
		
		Pageable pageable =  PageRequest.of(page, size);
		return bookService.getAllBooks(pageable);
	}
	
	@GetMapping("/all/{vid}")
	public ResponseEntity<?> getBooksByVendor(@PathVariable("vid") int vid) {
		/* Fetch vendor object using given vid */
		try {
			Vendor vendor = vendorService.getOne(vid);
			List<Book> list= bookService.getBooksByVendor(vid);
			return ResponseEntity.ok().body(list);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}
	
	@DeleteMapping("/{bid}")
	public ResponseEntity<?> deleteBook(@PathVariable("bid") int bid) {
	try {
		Book book = bookService.getById(bid);
		bookService.deleteBook(book.getId());
		return ResponseEntity.ok().body("Book Record deleted");
	} catch (InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}	
	}
	@PutMapping("/update/{id}")  //update: Books entity
	public ResponseEntity<?> updateBook(@PathVariable("id") int id,
							@RequestBody BookDto newBook) throws InvalidIdException {
		//validate id
		Book oldBook = bookService.getOne(id);
		if(newBook.getBookTitle() != null)
			oldBook.setBookTitle(newBook.getBookTitle());
		if(newBook.getAuthor() != null) 
			oldBook.setAuthor(newBook.getAuthor()); 
		if(newBook.getCategory() != null) 
			oldBook.setCategory(newBook.getCategory()); 
		if(newBook.getNumberOfCopies()!= null) 
			oldBook.setNumberOfCopies(newBook.getNumberOfCopies()); 
		
		oldBook = bookService.postBook(oldBook); 
		return ResponseEntity.ok().body(oldBook);
	}
}
