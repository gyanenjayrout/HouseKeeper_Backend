package com.HouseKEpping.entity;


public class jwtRequest {
	
	public jwtRequest(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	String username;
	String password;
	public jwtRequest() {
		
		// TODO Auto-generated constructor stub
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
	
	
	

}
