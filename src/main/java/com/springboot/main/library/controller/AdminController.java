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


import com.springboot.main.library.dto.AdminDto;
import com.springboot.main.library.exception.InvalidIdException;

import com.springboot.main.library.model.Admin;
import com.springboot.main.library.model.User;
import com.springboot.main.library.service.AdminService;
import com.springboot.main.library.service.UserService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostMapping("/add")
	public Admin insertadmin(@RequestBody Admin admin) {
		
		User user =admin.getUser();
		String passwordPlain =user.getPassword();
		String encodedPassword =passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
	     user.setRole("ADMIN");
	     
	     user =userService.insert(user);
	     admin.setUser(user);
	return	adminService.insert(admin);

}
	
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getone(@PathVariable("id")int id) throws InvalidIdException {
	    Admin admin = adminService.getOne(id);
		return ResponseEntity.ok().body(admin);

	}
	@GetMapping("/getall") /// vendor/getall?page=0&size=10
	public List<Admin> getAll(@RequestParam(value="page",required = false, defaultValue = "0") Integer page,
							   @RequestParam(value="size", required = false, defaultValue = "10000000") Integer size) { // v1 v2 v3 v4 v5
																										// : size & page

		Pageable pageable = PageRequest.of(page, size); // null null
		return adminService.getAll(pageable);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") int id) throws InvalidIdException {
		//validate id
		Admin admin = adminService.getOne(id);
		//delete
		adminService.deleteAdmin(admin);
		return ResponseEntity.ok().body("Admin deleted successfully");
	}
	@PutMapping("/update/{id}")  //:update: which record to update?   give me new value for update
	public ResponseEntity<?> updateAdmin(@PathVariable("id") int id,
							@RequestBody AdminDto newAdmin) throws InvalidIdException {
		//validate id
		Admin oldAdmin = adminService.getOne(id);
		if(newAdmin.getName() != null)
			oldAdmin.setName(newAdmin.getName());
		if(newAdmin.getEmail() != null) 
			oldAdmin.setEmail(newAdmin.getEmail()); 
		 
		oldAdmin = adminService.postAdmin(oldAdmin); 
		return ResponseEntity.ok().body(oldAdmin);
	}
}