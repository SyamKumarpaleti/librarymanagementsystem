package com.springboot.main.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.springboot.main.library.model.Student;
@Service
public interface StudentRepository extends JpaRepository<Student, Integer>{

}