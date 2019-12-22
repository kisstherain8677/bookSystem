package com.gyf.bookstore.model;

public class User {
	private String userid;
	private String username;
	private String password;
	private String role;
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}




	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password 
				+ ", role=" + role + "]";
	}	
	
}
