package com.springboot.main.library.controller;

import java.time.LocalDate;
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
import com.springboot.main.library.model.Admin;
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
	
	@PostMapping("/{cid}/{bid}")
	//@PostMapping("/{customerId}/{bookId}")
    public void borrowBook(@PathVariable("cid") int cid,@PathVariable("bid") int bid, @RequestBody List<CustomerBookDto> customerBookDtoList, double amount) throws InvalidIdException {
     
		/*try {
			
			Customer customer= customerService.getOne(cid);
			List<CustomerBook> bookstaken = new ArrayList<>();
			for(CustomerBookDto customerBookDto : customerBookDtoList)
			{
				String isbn = customerBookDto.getIsbn();
				Book book = bookService.getBook(isbn);
				CustomerBook customerBook = new CustomerBook();
				customerBook.setCustomer(customer);
				customerBook.setBook(book);
				customerBook.setIssueDate(LocalDate.now());
				customerBook.setAmount(amount=customerBookService.amount(bid,customerBookDto.getNoOfWeeks(),BookDto.getBookPrice()));
				customerBook.setNoOfWeeks(customerBookDto.getNoOfWeeks());
			    customerBook=customerBookService.save(customerBook);
				 bookstaken.add(customerBook);
				
			}
			 return ResponseEntity.ok().body(bookstaken);
		}catch (InvalidIdException e) {
			
		return ResponseEntity.badRequest().body(e.getMessage());
			
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		
		 // Check if the book is available
		Book book=null;
		try {
			book = bookService.getOne(bid);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (!book.getStatus().equals(" Not Available")) {
            throw new InvalidIdException("book Not Available");
        }
        for(CustomerBookDto customerBookDto : customerBookDtoList)
		{
        // Create a new BorrowedBook record
        CustomerBook customerBook = new CustomerBook();
        customerBook.setCustomer(customerService.getOne(cid));
        customerBook.setBook(book);
        customerBook.setIssueDate(LocalDate.now());
        customerBook.setNoOfWeeks(customerBookDto.getNoOfWeeks());
        customerBook.setAmount(amount=customerBookService.amount(bid,customerBookDto.getNoOfWeeks(),BookDto.getBookPrice()));
      
		
        // Update the book status to borrowed
        book.setStatus("borrowed");
        bookService.save(book);

        // Save the BorrowedBook record
        customerBookService.save(customerBook);
		}
        
    }*/
	//@PutMapping("/amount/{cbid}")

	}
	
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

