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
	public List<Book> getAllBook(
			@RequestParam(value="page",required = false,defaultValue = "0") Integer page,
			@RequestParam(value="size",required = false,defaultValue = "1000000") Integer size) {  
		
		Pageable pageable =  PageRequest.of(page, size);
		return bookService.getAllBook(pageable);
	}
	@GetMapping("/getone/{bid}")
	public ResponseEntity<?> getBookByBookid(@PathVariable("bid") int bid) {

		try {
			Book book = bookService.getOne(bid);
			return ResponseEntity.ok().body(book);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	/*fetch book by Admin id*/
	@GetMapping("/all/{id}")
	public ResponseEntity<?> getbookByAdmin(@PathVariable("id") int id) {
		try {
			Admin admin = adminService.getOne(id);
			List<Book> list= bookService.getbookByAdmin(id);
			return ResponseEntity.ok().body(list);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}
	/*Delete book by admin*/
	@DeleteMapping("/delete/{bid}/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") int id,@PathVariable("bid") int bid) {
		
		try {
			//validate id
			Admin admin = adminService.getOne(id);
			Book book=bookService.getOne(bid);
			//delete
			bookService.deleteBook(book);
			return ResponseEntity.ok().body("Book Deleted Successfully");

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PutMapping("/update/{bid}/{id}")  //:update: which record to update?   give me new value for update
	public ResponseEntity<?> updateBook(@PathVariable("id") int id,@PathVariable("bid") int bid,
							@RequestBody BookDto newBook) {
		try {
			//validate id
			Admin admin = adminService.getOne(id);
			Book oldBook=bookService.getOne(bid);
			if(newBook.getBookTitle() != null)
				oldBook.setBookTitle(newBook.getBookTitle());
			if(newBook.getAuthor() != null)
				oldBook.setAuthor(newBook.getAuthor());
			if(newBook.getCategory() != null)
				oldBook.setCategory(newBook.getCategory());
			if(newBook.getBookTitle() != null)
				oldBook.setBookTitle(newBook.getBookTitle());
			if(newBook.getNumberOfCopies() != null)
				oldBook.setNoOfCopies(newBook.getNumberOfCopies());
			if(newBook.getIsbn() != null)
				oldBook.setIsbn(newBook.getIsbn());
			if(newBook.getBookPrice() != null)
				oldBook.setBookPrice(newBook.getBookPrice());  
			if(newBook.getStatus() != null)
				oldBook.setStatus(newBook.getStatus());
			oldBook = bookService.postBook(oldBook); 
			return ResponseEntity.ok().body(oldBook);

		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
}
	
}
