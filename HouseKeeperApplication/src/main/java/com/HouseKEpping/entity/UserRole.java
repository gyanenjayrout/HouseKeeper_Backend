package com.HouseKEpping.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class UserRole {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long UserRoleId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference 
	@JsonIgnore
	private User user;
	@ManyToOne(fetch=FetchType.EAGER)
	@JsonBackReference 
	@JsonIgnore
	private Role role;
	public Long getUserRoleId() {
		return UserRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		UserRoleId = userRoleId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	

}
 
