package com.springboot.main.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.library.exception.InvalidIdException;
import com.springboot.main.library.model.Admin;
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

	public Book getOne(int bid) throws InvalidIdException{
		Optional<Book> optional =  bookRepository.findById(bid);
		if(!optional.isPresent()){
			throw new InvalidIdException("Book ID Invalid");
		}
		return optional.get();
	}

	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		bookRepository.delete(book);
		
	}

	public Book getBookTitle(String bookTitle) {
		// TODO Auto-generated method stub
		return bookRepository.findBookTitle(bookTitle);
	}

	public Book getAuthor(String author) {
		// TODO Auto-generated method stub
		return bookRepository.findAuthor(author);
	}

	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findBook(id);
	}

	
}
