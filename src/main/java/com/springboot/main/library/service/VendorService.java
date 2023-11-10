package com.springboot.main.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.library.model.Vendor;
import com.springboot.main.library.repository.VendorRepository;
@Service
public class VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	public Vendor insert(Vendor vendor) {
		
		return vendorRepository.save(vendor);
	}

}
