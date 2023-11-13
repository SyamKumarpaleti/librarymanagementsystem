package com.springboot.main.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.main.library.model.StudentBook;

public interface StudentBookRepository extends JpaRepository<StudentBook, Integer>{
	@Query("select sb from StudentBook sb where sb.student.id =?1")
	List<StudentBook> getMyBookStatus(int sid);

}
