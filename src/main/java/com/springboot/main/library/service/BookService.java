package com.springboot.main.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
}