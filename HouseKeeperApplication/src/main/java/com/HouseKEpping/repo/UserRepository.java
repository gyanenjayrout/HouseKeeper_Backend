package com.HouseKEpping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HouseKEpping.entity.User;



public interface UserRepository extends JpaRepository<User,Long> {

	User findUserByUsername(String username);

}
