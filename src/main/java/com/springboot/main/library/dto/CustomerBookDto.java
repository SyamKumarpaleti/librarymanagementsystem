package com.springboot.main.library.dto;

import java.time.LocalDate;

public class CustomerBookDto {
	private String isbn;
	private LocalDate issueDate;
	private int noOfWeeks;
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public int getNoOfWeeks() {
		return noOfWeeks;
	}

	public void setNoOfWeeks(int noOfWeeks) {
		this.noOfWeeks = noOfWeeks;
	}

	@Override
	public String toString() {
		return "CustomerBookDto [isbn=" + isbn + ",  issueDate=" + issueDate + ", noOfWeeks="
				+ noOfWeeks + "]";
	}

}
