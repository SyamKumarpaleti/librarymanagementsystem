package com.springboot.main.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Customer;
import com.springboot.main.library.model.User;
import com.springboot.main.library.service.CustomerService;
import com.springboot.main.library.service.UserService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostMapping("/post")
	public Customer insertCustomer(@RequestBody Customer customer) {
		
		User user =customer.getUser();
		String passwordPlain =user.getPassword();
		String encodedPassword =passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
	     user.setRole("CUSTOMER");
	     
	     user =userService.insert(user);
	     customer.setUser(user);
	return	customerService.insert(customer);
		
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getone(@PathVariable("id")int id) throws InvalidIdException {
	    Customer customer = customerService.getOne(id);
		return ResponseEntity.ok().body(customer);

	}
	@GetMapping("/getall") /// student/getall?page=0&size=10
	public List<Customer> getAll(@RequestParam(value="page",required = false, defaultValue = "0") Integer page,
							   @RequestParam(value="size", required = false, defaultValue = "10000000") Integer size) { // v1 v2 v3 v4 v5
																										// : size & page

		Pageable pageable = PageRequest.of(page, size); // null null
		return customerService.getAll(pageable);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) throws InvalidIdException {
		//validate id
		Customer customer = customerService.getOne(id);
		//delete
		customerService.deleteStudent(customer);
		return ResponseEntity.ok().body("Customer deleted successfully");
	}
	@PutMapping("/update/{id}")  //:update: which record to update?   give me new value for update
	public ResponseEntity<?> updateAdmin(@PathVariable("id") int id,
							@RequestBody Customer newCustomer) throws InvalidIdException {
		//validate id
		Customer oldCustomer =customerService.getOne(id);
		if(newCustomer.getName() != null)
			oldCustomer.setName(newCustomer.getName());
		if(newCustomer.getEmail() != null) 
			oldCustomer.setEmail(newCustomer.getEmail()); 
		 
		oldCustomer = customerService.postStudent(oldCustomer); 
		return ResponseEntity.ok().body(oldCustomer);
	}
	

}