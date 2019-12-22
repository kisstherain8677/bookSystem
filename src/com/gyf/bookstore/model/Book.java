package com.gyf.bookstore.model;

import com.sun.mail.handlers.text_html;

public class Book {
	private String bookId;
	private String bookName;
	private String author;
	private String publisher;
	private int num;
	private int restNum;
	private String category;
	private String description;
	private String initlocation;
	
	
	
	public String getInitlocation() {
		return initlocation;
	}
	public void setInitlocation(String initlocation) {
		this.initlocation = initlocation;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String auther) {
		this.author = auther;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRestNum() {
		return restNum;
	}
	public void setRestNum(int restNum) {
		this.restNum = restNum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString()
	{
		return "Book{" +
			   "bookId='" + bookId + '\'' +
			   ", bookName='" + bookName + '\'' +
			   ", author='" + author + '\'' +
			   ", publisher='" + publisher + '\'' +
			   ", num=" + num +
			   ", restNum=" + restNum +
			   ", category='" + category + '\'' +
			   ", description='" + description + '\'' +
			   ", initlocation='" + initlocation + '\'' +
			   '}';
	}
}
