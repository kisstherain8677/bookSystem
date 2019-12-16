package com.gyf.bookstore.model;

import java.util.Date;

public class Outlist {
	private String abookid;
    private String bookname;
    private Date borrowdate;
	public String getAbookid() {
		return abookid;
	}
	public void setAbookid(String abookid) {
		this.abookid = abookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}
       
}
