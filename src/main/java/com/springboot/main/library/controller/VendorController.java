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

import com.springboot.main.library.dto.VendorDto;
import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.User;
import com.springboot.main.library.model.Vendor;
import com.springboot.main.library.service.UserService;
import com.springboot.main.library.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/post")
	public Vendor insertVendor(@RequestBody Vendor vendor) {

		User user = vendor.getUser();
		String passwordPlain = user.getPassword();
		String encodedPassword = passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		user.setRole("VENDOR");
		user = userService.insert(user);
		vendor.setUser(user);
		return vendorService.insert(vendor);

	}

	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getone(@PathVariable("id")int id) throws InvalidIdException {
	    Vendor vendor = vendorService.getOne(id);
		return ResponseEntity.ok().body(vendor);

	}
	@GetMapping("/getall") /// vendor/getall?page=0&size=10
	public List<Vendor> getAll(@RequestParam(value="page",required = false, defaultValue = "0") Integer page,
							   @RequestParam(value="size", required = false, defaultValue = "10000000") Integer size) { // v1 v2 v3 v4 v5
																										// : size & page

		Pageable pageable = PageRequest.of(page, size); // null null
		return vendorService.getAll(pageable);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVendor(@PathVariable("id") int id) throws InvalidIdException {
		//validate id
		Vendor vendor = vendorService.getOne(id);
		//delete
		vendorService.deleteVendor(vendor);
		return ResponseEntity.ok().body("vendor deleted successfully");
	}
	@PutMapping("/update/{id}")  //:update: which record to update?   give me new value for update
	public ResponseEntity<?> updateVendor(@PathVariable("id") int id,
							@RequestBody VendorDto newVendor) throws InvalidIdException {
		//validate id
		Vendor oldVendor = vendorService.getOne(id);
		if(newVendor.getName() != null)
			oldVendor.setName(newVendor.getName());
		if(newVendor.getEmail() != null) 
			oldVendor.setEmail(newVendor.getEmail()); 
		 
		oldVendor = vendorService.postVendor(oldVendor); 
		return ResponseEntity.ok().body(oldVendor);
	}
}