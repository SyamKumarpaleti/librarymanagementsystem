package com.springboot.main.library.dto;

import java.time.LocalDate;

import com.springboot.main.library.model.Book;
import com.springboot.main.library.model.Customer;

public class CustomerBookDto {
	
	private LocalDate issueDate;
	private LocalDate returnDate;
	private Double amount;
	

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void SetCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void SetBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	
	

	
}
