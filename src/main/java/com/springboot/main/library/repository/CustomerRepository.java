package com.springboot.main.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.main.library.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	

}