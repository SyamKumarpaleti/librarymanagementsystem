package com.springboot.main.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String bookTitle;
	private String author;
	private String category;
	private String isbn;

	private double bookPrice;
<<<<<<< HEAD
	private String noOfCopies;
	
=======
	private String numberOfCopies;

>>>>>>> bf2e9b5ac8ce8e56b917fc0ecf445196ba7aa45b
	@ManyToOne
	private Admin admin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookTitle=" + bookTitle + ", author=" + author + ", category=" + category
				+ ", isbn=" + isbn + ", bookPrice=" + bookPrice + ", numberOfCopies=" + numberOfCopies + ", admin="
				+ admin + "]";
	}

}