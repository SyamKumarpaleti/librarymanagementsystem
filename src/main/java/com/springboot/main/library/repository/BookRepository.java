package com.springboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.library.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{

	

}
