package com.springboot.main.library.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Customer;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.model.Book;
>>>>>>> 7f4a34bfbac6ef898c5df5e99cbf3f0a556a2253
import com.springboot.main.library.model.CustomerBook;
import com.springboot.main.library.model.User;
import com.springboot.main.library.service.BookService;
import com.springboot.main.library.service.CustomerBookService;
<<<<<<< HEAD
import com.springboot.main.library.service.CustomerService;
=======
>>>>>>> 7f4a34bfbac6ef898c5df5e99cbf3f0a556a2253
import com.springboot.main.library.service.UserService;

@RestController
@CrossOrigin(origins=("http://localhost:3000"))
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
<<<<<<< HEAD
	private CustomerService customerService;
	@Autowired
	private CustomerBookService customerBookService;
	
=======
	private CustomerBookService customerBookService;
>>>>>>> 7f4a34bfbac6ef898c5df5e99cbf3f0a556a2253

	@PostMapping("/user/login")
	public User login(Principal principal) {
		String username = principal.getName();
		User user = (User) userService.loadUserByUsername(username);
		return user;

	}
<<<<<<< HEAD
	
	//display the books that have been burrowed by given  customer id from start_date to end_date. take id as path variable. 
   @GetMapping("/customerbook/{id}")
   public ResponseEntity<?> getCustomerBook(@PathVariable("id") int id)  {
	   try {
		Customer customer=customerService.getCustomer(id);
		  List<CustomerBook> list=customerBookService.getCutomerBooks(id);
		  return ResponseEntity.ok().body(list);
	} catch (InvalidIdException e) {
		// TODO Auto-generated catch block
		return ResponseEntity.badRequest().body(e.getMessage());
		}
	   
   }
   //Display all Customers that have borrowed books belonging to category=FICTION and having price less than INR. 1000
  @GetMapping("/bookcustomer/{catgeory}/{price}")
   public ResponseEntity<?> getCustomer(@PathVariable("category") String category,@PathVariable("price") double price) {
	  List<Customer> list=bookService.getCustomerByCategoryAndPrice(category,price);
	 return ResponseEntity.ok().body(list);
   }
   
=======
	@GetMapping("/book/customer/{bookid}")
	public List<CustomerBook> getCustomers(@PathVariable("bookid") int id) {
		Book book=bookService.getBook(id);
		List<CustomerBook> customers=customerBookService.getcustomersBybookid(id);
		return customers;
		
	}

>>>>>>> 7f4a34bfbac6ef898c5df5e99cbf3f0a556a2253
}