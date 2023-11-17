package com.springboot.main.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.library.service.BookService;
import com.springboot.main.library.service.CustomerService;

@RestController
@RequestMapping("/customerBook")
public class CustomerBookController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BookService bookService;
	
	/*@PostMapping("/book/customer/{bid}/{cid}")*/

}
