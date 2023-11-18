package com.springboot.main.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Book;
import com.springboot.main.library.model.CustomerBook;
import com.springboot.main.library.repository.BookRepository;
import com.springboot.main.library.repository.CustomerBookRepository;


@Service
public class CustomerBookService {
	@Autowired
	private CustomerBookRepository customerBookRepository;
	@Autowired
	private BookRepository bookRepository;

	public CustomerBook save(CustomerBook customerBook) {
		
		
		return customerBookRepository.save(customerBook);
	}

	public List<?> getcustomers(int bid) {
		
		return customerBookRepository.getcustomers(bid);
	}

	public List<?> getbooks(int cid) {
		
		return customerBookRepository.getbooks(cid);
	}

	public double amount(int bid, int noOfWeeks, double bookPrice) throws InvalidIdException {
		Optional<Book> optional = bookRepository.findById(bid);
	    if (!optional.isPresent())
	        throw new InvalidIdException("Book does not exist");
		double amount;
		if(noOfWeeks==1) {
			return amount=bookPrice+bookPrice*0.04;
		}
		else if(noOfWeeks==2) {
			return amount=bookPrice+bookPrice*0.04;
		}
		else if(noOfWeeks==3) {
			return amount=bookPrice+bookPrice*0.06;
		}
		else if(noOfWeeks==4) {
			return amount=bookPrice+bookPrice*0.08;
		}
		
		
		throw new InvalidIdException("Enter valid no of weeks");
	}

	
	

}
