package com.tmdt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tmdt.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserName(String username);

}
