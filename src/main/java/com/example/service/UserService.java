package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.jpa.UserRepository;
import com.example.pojo.User;


@Service
public class UserService {

	@Autowired
	private UserRepository  userRepo;

	
	
	
	public List<String> getCountries() {

List<String> countries=new ArrayList<String>();
countries.add("India");
countries.add("USA");
countries.add("Germany");
		return countries;
	}


	
	public boolean save(User user) {
		user.setActivesw("true");
		User u = userRepo.save(user);
		return (u.getUserId() != null) ? true : false;
	}




	
	/*
	 * public List<User> getAllUsers(PageRequest page) {
	 * 
	 * 
	 * Page<User> it = userRepo.findAll(page);
	 * 
	 * List<User> users = new ArrayList<User>();
	 * 
	 * 
	 * it.forEach(e -> users.add(e));
	 * 
	 * return users;
	 * 
	 * }
	 */

	
	
	
	  public List<User> getAllUsers(PageRequest page) 
	  {
	  
	  Page<User> items = userRepo.findAll(page);
	  
	  ArrayList<User> users = new ArrayList<User>();
	  
	  if (!items.isEmpty()) 
	  { 
	  for (User user : items) 
	  { 
	  if
	  ("true".equals(user.getActiveSw()))
	  { 
		
	  
	  user.setUsername(user.getUsername());
	  user.setEmail(user.getEmail());
	  user.setPhno(user.getPhno()); 
	  user.setCountry(user.getCountry());
	  
	  users.add(user);
	  } 
	  }
	  } 
	  
	  return users; 
	  }


	  public boolean softDelete(Integer userId) {
	  

	  userRepo.delete(userId);
	
	   
	  return true;
	  
	  }



	/*
	 * public void delete(Integer userId) {
	 * 
	 * userRepo.deleteById(userId); }
	 */


	public User findById(Integer userId) {
		
		 return userRepo.findById(userId).get();
		
	}



	public ArrayList<String> findAllEmails() {
		
		return userRepo.findAllEmails();
	}



	public String findEmailById(Integer userId) {
	
		return userRepo.findEmailById(userId);
	}




}