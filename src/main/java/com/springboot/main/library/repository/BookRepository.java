package com.springboot.main.library.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.main.library.model.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByVendorId(int vid);
    

	

}