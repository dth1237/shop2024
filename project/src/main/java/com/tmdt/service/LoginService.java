package com.tmdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmdt.model.Login;
import com.tmdt.repos.LoginRepository;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository repo;
  
  public Login login(String username, String password) {
      Login user = repo.findByUsernameAndPassword(username, password);
      return user;
  }
    
}