package com.springboot.main.library.repository;




import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.main.library.model.Book;
import com.springboot.main.library.model.Customer;


public interface BookRepository extends JpaRepository<Book, Integer>{


	@Query("select b from Book b where b.id=?1")
	List<Book> getBookByAdminJpql(int id);

	List<Book> findByAdminId(int id);
	
	@Query(value = "select * from book where book_title=?1",nativeQuery = true)
	Book findBookTitle(String bookTitle);
	@Query(value = "select * from book where author=?1",nativeQuery = true)
	Book findAuthor(String author);
	@Query(value = "select * from book where id=?1",nativeQuery = true)
	Book findBook(int id);
	
   /* @Query(value = "select * from book where book_title=?1",nativeQuery = true)
	Customer findBookTitle(String bookTitle);*/
	
   
	
	
    

	

}
