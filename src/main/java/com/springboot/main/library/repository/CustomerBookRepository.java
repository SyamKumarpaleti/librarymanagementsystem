package com.springboot.main.library.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.main.library.model.CustomerBook;

public interface CustomerBookRepository extends JpaRepository<CustomerBook, Integer>{
	
}
