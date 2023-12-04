package com.springboot.main.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.main.library.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
   
	
	
    

	

}