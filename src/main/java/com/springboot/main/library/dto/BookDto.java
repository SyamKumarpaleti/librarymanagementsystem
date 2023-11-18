package com.springboot.main.library.dto;

public class BookDto {
	private String bookTitle;
	private String author;
	private String category;
	private String numberOfCopies;
	private String isbn;

<<<<<<< HEAD
	private double bookPrice;
=======
	private static double bookPrice;

	

	private String status;
>>>>>>> 03bc5c1ac783a799d7f4858085cc6dcb8b9a162b

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
<<<<<<< HEAD

	public double getBookPrice() {
=======
	
	
	public static double getBookPrice() {
>>>>>>> 03bc5c1ac783a799d7f4858085cc6dcb8b9a162b
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

	@Override
	public String toString() {
		return "BookDto [bookTitle=" + bookTitle + ", author=" + author + ", category=" + category + ", numberOfCopies="
				+ numberOfCopies + ", isbn=" + isbn + ", bookPrice=" + bookPrice + "]";
	}
<<<<<<< HEAD
=======
	
	
	
	
	

>>>>>>> 03bc5c1ac783a799d7f4858085cc6dcb8b9a162b

}