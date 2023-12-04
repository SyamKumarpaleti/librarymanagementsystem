package com.springboot.main.library.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.model.Book;
import com.springboot.main.library.model.CustomerBook;
import com.springboot.main.library.model.User;
import com.springboot.main.library.service.BookService;
import com.springboot.main.library.service.CustomerBookService;
import com.springboot.main.library.service.UserService;

@RestController
@CrossOrigin(origins=("http://localhost:3000"))
public class AuthController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CustomerBookService customerBookService;

	@PostMapping("/user/login")
	public User login(Principal principal) {
		String username = principal.getName();
		User user = (User) userService.loadUserByUsername(username);
		return user;

	}
	@GetMapping("/book/customer/{bookid}")
	public List<CustomerBook> getCustomers(@PathVariable("bookid") int id) {
		Book book=bookService.getBook(id);
		List<CustomerBook> customers=customerBookService.getcustomersBybookid(id);
		return customers;
		
	}

}