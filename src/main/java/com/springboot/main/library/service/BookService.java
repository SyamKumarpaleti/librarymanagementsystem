package com.springboot.main.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.library.model.Book;
import com.springboot.main.library.repository.BookRepository;
@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book postBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	public List<Book> getAllBook(Pageable pageable) {
		// TODO Auto-generated method stub
		return bookRepository.findAll(pageable).getContent();
	}

	public List<Book> getbookByAdmin(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findByAdminId(id);
	}

}
