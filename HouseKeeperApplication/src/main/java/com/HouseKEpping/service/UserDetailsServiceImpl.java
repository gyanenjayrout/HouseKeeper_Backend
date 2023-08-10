package com.HouseKEpping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.HouseKEpping.repo.UserRepository;
import com.HouseKEpping.entity.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
   private UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
	    this.userRepository=userRepository;
	  }

   
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = this.userRepository.findUserByUsername(username);
		
		if(user==null)
		{
			System.out.println("User is not exist");
			throw new UsernameNotFoundException("User not found");
		}
		
		return user;
	}

}
