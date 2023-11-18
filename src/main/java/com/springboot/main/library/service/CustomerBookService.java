package com.springboot.main.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.library.model.CustomerBook;
import com.springboot.main.library.repository.CustomerBookRepository;


@Service
public class CustomerBookService {
	@Autowired
	private CustomerBookRepository customerBookRepository;

	public CustomerBook save(CustomerBook customerBook) {
		
		
		return customerBookRepository.save(customerBook);
	}

	public List<?> getcustomers(int bid) {
		
		return customerBookRepository.getcustomers(bid);
	}

	public List<?> getbooks(int cid) {
		
		return customerBookRepository.getbooks(cid);
	}
	

}
