package com.springboot.main.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Vendor;
import com.springboot.main.library.repository.VendorRepository;
@Service
public class VendorService {
	@Autowired
	private VendorRepository vendorRepository;

	public Vendor insert(Vendor vendor) {
		
		return vendorRepository.save(vendor);
	}



	public Vendor getById(int vid) throws InvalidIdException {
		Optional<Vendor> optional =vendorRepository.findById(vid);
		if(!optional.isPresent())
			throw new InvalidIdException("Vendor id Invalid");
		return optional.get();
	}

}
