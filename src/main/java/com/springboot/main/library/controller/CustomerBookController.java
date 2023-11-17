package com.springboot.main.library.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Book;
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
	
	/*@PostMapping("/book/customer/{bid}/{cid}")*/
	@PostMapping("/{customerId}/{bookId}")
    public ResponseEntity<CustomerBook> borrowBook(@PathVariable("id") int id, @PathVariable("bid") int bid, int noOfWeeks, double amount) throws InvalidIdException {
        // Check if the book is available
		Book book=null;
		try {
			book = bookService.getOne(bid);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (!book.getStatus().equals("available")) {
            throw new InvalidIdException("book Not Available");
        }

        // Create a new BorrowedBook record
        CustomerBook customerBook = new CustomerBook();
        customerBook.setCustomer(customerService.getOne(id));
        customerBook.setBook(book);
        customerBook.setIssueDate(LocalDate.now());
        customerBook.setNoOfWeeks(noOfWeeks);
        customerBook.setAmount(amount);
      

        // Update the book status to borrowed
        book.setStatus("borrowed");
        bookService.save(book);

        // Save the BorrowedBook record
        customerBookService.save(customerBook);

        return ResponseEntity.ok(customerBook);
    }

}
