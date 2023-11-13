package com.springboot.main.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
	public  Vendor getOne(int id) throws InvalidIdException {
		Optional<Vendor> optional=vendorRepository.findById(id);
		if(!optional.isPresent()){
			throw new InvalidIdException("vendor ID Invalid");
		}
		return optional.get();
	}
	public List<Vendor> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return vendorRepository.findAll(pageable).getContent();
	}

	public void deleteVendor(Vendor vendor) {
		vendorRepository.delete(vendor);
	}

	public Vendor postVendor(Vendor vendor) {
		
		return vendorRepository.save(vendor);
	}
	public Vendor getById(int vid) throws InvalidIdException {
		Optional<Vendor> optional=vendorRepository.findById(vid);
		if(!optional.isPresent()){
			throw new InvalidIdException("vendor ID Invalid");
		}
		return optional.get();
	

}
}
