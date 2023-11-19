package com.springboot.main.library.dto;

public class BookDto {
	private String bookTitle;
	private String author;
	private String category;
	private String noOfCopies;
	private String isbn;

<<<<<<< HEAD
	private  double bookPrice;
=======
	private double bookPrice;

>>>>>>> bf2e9b5ac8ce8e56b917fc0ecf445196ba7aa45b
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
<<<<<<< HEAD
	
	
	public  double getBookPrice() {
=======

	public double getBookPrice() {
>>>>>>> bf2e9b5ac8ce8e56b917fc0ecf445196ba7aa45b
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
<<<<<<< HEAD
	
	public String getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(String noOfCopies) {
		this.noOfCopies = noOfCopies;
=======

	public String getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(String numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
>>>>>>> bf2e9b5ac8ce8e56b917fc0ecf445196ba7aa45b
	}

	@Override
	public String toString() {
		return "BookDto [bookTitle=" + bookTitle + ", author=" + author + ", category=" + category + ", noOfCopies="
				+ noOfCopies + ", isbn=" + isbn + ", bookPrice=" + bookPrice + "]";
	}
<<<<<<< HEAD
	
=======
>>>>>>> bf2e9b5ac8ce8e56b917fc0ecf445196ba7aa45b

}