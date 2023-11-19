package com.springboot.main.library.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.dto.BookDto;
import com.springboot.main.library.dto.CustomerBookDto;
import com.springboot.main.library.exception.InvalidIdException;

import com.springboot.main.library.model.Book;
import com.springboot.main.library.model.Customer;
import com.springboot.main.library.model.CustomerBook;
import com.springboot.main.library.service.BookService;
import com.springboot.main.library.service.CustomerBookService;
import com.springboot.main.library.service.CustomerService;

@RestController
@RequestMapping("/customerBook")
public class CustomerBookController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CustomerBookService customerBookService;
	
	@PostMapping("/{id}/{bid}")
	//@PostMapping("/{customerId}/{bookId}")
    public ResponseEntity<?> createCustomerBook(@PathVariable("id") int id,@PathVariable("bid") int bid, @RequestBody CustomerBook customerBook)  {
     
		
		try {
			Customer customer = customerService.getOne(id);
			Book book=bookService.getOne(bid);
			customerBook. setCustomer(customer) ;
			customerBook. setBook(book);
			
			LocalDate issueDate=customerBook.getIssueDate();
			LocalDate returnDate=customerBook.getReturnDate();
			
			long days = ChronoUnit.DAYS.between(issueDate, returnDate);
			
	        double amount = days * 0.2;
	        
	
			customerBook. setAmount(amount);
			
			 customerBook=customerBookService.createCustomerBook(customerBook);
			 return ResponseEntity.ok().body(customerBook);
			
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		}
		
		/* localhost:8182/customerBook/30/7
		 * 
		 *  {
  "issueDate": "2023-10-04",
  "returnDate": "2023-10-18"
}*/
	@GetMapping("/bookid/{bid}")
	public ResponseEntity<?> getcustomers(@PathVariable("bid") int bid ) {
		try {
			Book book = bookService.getOne(bid);
			
		return ResponseEntity.ok().body(customerBookService.getcustomers(bid));
			
		}
		catch (InvalidIdException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}
	/*       localhost:8182/customerBook/customerid/37     */
	@GetMapping("/customerid/{cid}")
	public ResponseEntity<?> getbooks(@PathVariable("cid") int cid ) {
		try {
			Customer customer = customerService.getOne(cid);
			
		return ResponseEntity.ok().body(customerBookService.getbooks(cid));
			
		}
		catch (InvalidIdException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}

	}	

	
	
	/*
	@GetMapping("/getstatus/{status}")
	public Book getStatus(@PathVariable("status") String status) {
	Book book=bookService.getStatus(status);
	return book;
	}
	*/
	
	/*
	
	@GetMapping("/all/{cbid}")
	public ResponseEntity<?> getbookByStatus(@PathVariable("cbid") int cbid) {
		try {
			Customer customer = customerService.getOne(cbid);
			List<Book> list= bookService.getbookByStatus(cbid);
			return ResponseEntity.ok().body(list);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}
	
	*/
	
	
	
}

