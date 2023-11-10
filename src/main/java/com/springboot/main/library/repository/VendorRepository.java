package com.springboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.library.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}