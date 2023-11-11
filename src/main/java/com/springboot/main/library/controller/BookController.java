package com.springboot.main.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		/*catch (InvalidIdException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			*/
	}
}
