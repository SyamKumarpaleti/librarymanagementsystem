package com.springboot.main.library.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Book;

import com.springboot.main.library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book insert(Book book) {
		
		return bookRepository.save(book);
	}

	public List<Book> getAllBooks(Pageable pageable) {
		// TODO Auto-generated method stub
		return bookRepository.findAll(pageable).getContent() ;
	}
	public List<Book> getBooksByVendor(int vid) {
		// TODO Auto-generated method stub
		return bookRepository.findByVendorId(vid);
	}

	
	
	public Book getById(int bid)  throws InvalidIdException {

		Optional<Book> optional = bookRepository.findById(bid);
		if (!optional.isPresent())
			throw new InvalidIdException("Book id invalid");
		return optional.get();
	}

	public Book deleteBook(int bid) throws InvalidIdException {

		Optional<Book> optional = bookRepository.findById(bid);
		if (!optional.isPresent())
			throw new InvalidIdException("Book id invalid");
		return optional.get();
	}


}