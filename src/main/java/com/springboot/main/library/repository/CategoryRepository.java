package com.springboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.library.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	

}
