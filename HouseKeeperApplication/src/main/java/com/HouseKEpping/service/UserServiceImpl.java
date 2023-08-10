package com.HouseKEpping.service;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.HouseKEpping.repo.RoleRepository;
import com.HouseKEpping.repo.UserRepository;
import com.HouseKEpping.entity.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    //creating User
    
    
    

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws DuplicateKeyException {
        User local = userRepository.findUserByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User Already Exists");
            throw new DuplicateKeyException("User already exists");
        } else {
        	
        	for(UserRole ur:userRoles)
        	{
        		roleRepository.save(ur.getRole());
        		
        	}
        	user.getUserRole().addAll(userRoles);
        	local =this.userRepository.save(user);
        }

        return local;
    }

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findUserByUsername(username);
	}

	@Override
	public void deleteUSer(Long userId) {
		this.userRepository.deleteById(userId);
		
	}
}
