package com.springboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.springboot.main.library.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}