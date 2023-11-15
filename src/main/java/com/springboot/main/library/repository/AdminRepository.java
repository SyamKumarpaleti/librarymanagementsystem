package com.springboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.main.library.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{

}