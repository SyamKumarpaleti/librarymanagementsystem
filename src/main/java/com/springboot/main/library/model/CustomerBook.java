package com.springboot.main.library.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderTable")
public class CustomerBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	@OneToOne
	private Customer customer;
	@OneToOne
	private Book book;
	private LocalDate issueDate;
	private int noOfWeeks;
	private double amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CustomerBook [id=" + id + ", customer=" + customer + ", book=" + book + ", issueDate=" + issueDate
				+ ", noOfWeeks=" + noOfWeeks + ", amount=" + amount + "]";
	}
	
}