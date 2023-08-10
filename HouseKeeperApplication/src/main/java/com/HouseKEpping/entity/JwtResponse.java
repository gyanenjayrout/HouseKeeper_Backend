package com.HouseKEpping.entity;


public class JwtResponse {
	
	

	public JwtResponse() {
		
		
	}

	String token;
	String username;

	public String getUsername() {
		return username;
	}

	public JwtResponse(String token, String username) {
		super();
		this.token = token;
		this.username = username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
