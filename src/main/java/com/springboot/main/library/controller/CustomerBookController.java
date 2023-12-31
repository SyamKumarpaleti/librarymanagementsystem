package com.springboot.main.library.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins=("http://localhost:3000"))
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
			double amount=customerBook.getBook().getBookPrice();
			double amount1=0;
			long days = ChronoUnit.DAYS.between(issueDate, returnDate);
			if(days<=7) {
	          amount1 +=(amount* 0.2);
			}
			else if(days>7 && days<=14){
				 amount1+=(amount*0.4);
			}
			else if(days>14 && days<=21){
				 amount1+=(amount*0.6);
			}
			else {
				 amount1+=(amount*0.8);
			}
	
			customerBook. setAmount(amount1);
			
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
	@GetMapping("/{id}/{issueDate}/{returnDate}")
	public ResponseEntity<?> getCustomerBooks(@PathVariable("id") int cid, @PathVariable("issueDate") String issueDate, @PathVariable("returnDate") String returnDate) {
		List<CustomerBook> customerBooks = customerBookService.getCustomerBooksByCustomerId(cid, LocalDate.parse(issueDate), LocalDate.parse(returnDate));
		
		return ResponseEntity.ok().body(customerBooks);
	}
	
	
}

