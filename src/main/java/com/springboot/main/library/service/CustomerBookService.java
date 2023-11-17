package com.springboot.main.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.library.model.CustomerBook;
import com.springboot.main.library.repository.CustomerBookRepository;
@Service
public class CustomerBookService {
	@Autowired
	private CustomerBookRepository customerBookRepository;

	public void save(CustomerBook customerBook) {
		// TODO Auto-generated method stub
		
	}
	

}
