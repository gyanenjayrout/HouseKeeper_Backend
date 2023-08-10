package com.HouseKEpping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HouseKEpping.entity.*;
import com.HouseKEpping.service.UserService;

import org.springframework.http.MediaType;


import java.util.*;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserContoller {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncrypter;
	
	@PostMapping("/")
	
	public User createUser(@RequestBody User user) {
		//encoding passwrd with brcyptPasswordencoder
		
		user.setPassword(this.bcryptPasswordEncrypter.encode(user.getPassword()));
	    Set<UserRole> roles = new HashSet<>();

	    Role role = new Role();
	    role.setRoleId(30L);
	    role.setRoleName("NORMAL");

	    UserRole userRole = new UserRole();
	    userRole.setUser(user);
	    userRole.setRole(role);

	    roles.add(userRole);

	    return this.userService.createUser(user, roles);
	}

	@GetMapping("/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
	    User user = this.userService.getUser(username);
	    if (user != null) {
	        return ResponseEntity.ok(user);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
	    this.userService.deleteUSer(userId);
	    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	

}
