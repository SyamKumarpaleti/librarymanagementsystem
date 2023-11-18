package com.springboot.main.library.dto;

public class BookDto {
	private String bookTitle;
	private String author;
	private String category;
	private String numberOfCopies;
	private String isbn;
	private static double bookPrice;
	private String status;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	public static double getBookPrice() {
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(String numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookDto [bookTitle=" + bookTitle + ", author=" + author + ", category=" + category + ", numberOfCopies="
				+ numberOfCopies + ", isbn=" + isbn + ", bookPrice=" + bookPrice + ", status=" + status + "]";
	}
	
	
	
	
	

}
