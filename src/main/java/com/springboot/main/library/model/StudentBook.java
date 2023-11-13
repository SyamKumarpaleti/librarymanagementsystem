package com.springboot.main.library.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StudentBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	@OneToOne
	private Student student;
	@OneToOne
	private Book book;
	private boolean issue;
	private LocalDate issueDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
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
	
	
	public boolean isIssue() {
		return issue;
	}
	public void setIssue(boolean issue) {
		this.issue = issue;
	}
	@Override
	public String toString() {
		return "StudentBook [id=" + id + ", student=" + student + ", book=" + book + ", issue=" + issue + ", issueDate="
				+ issueDate + "]";
	}
	
	

}