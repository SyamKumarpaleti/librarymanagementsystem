package com.springboot.main.library.dto;

import com.springboot.main.library.model.Category;

public class BookDto {
	private String bookTitle;
	private String author;
	private Category category;
	private String noOfCopies;
	private String isbn;


	private double bookPrice;


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	


	public double getBookPrice() {

		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public String getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(String noOfCopies) {
		this.noOfCopies = noOfCopies;

	}
	

	@Override
	public String toString() {
		return "BookDto [bookTitle=" + bookTitle + ", author=" + author + ", category=" + category + ", noOfCopies="
				+ noOfCopies + ", isbn=" + isbn + ", bookPrice=" + bookPrice + "]";
	}

}