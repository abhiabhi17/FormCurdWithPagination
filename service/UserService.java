package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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


	
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}




	
	public Iterable<User> getAllUsers() {
	
		 Iterable<User> it = userRepo.findAll();

	        ArrayList<User> users = new ArrayList<User>();
	        it.forEach(e -> users.add(e));

	        return users;
	
	}








	public void delete(Integer userId) {
	
	 userRepo.deleteById(userId);
	}



	public User findById(Integer userId) {
		
		 return userRepo.findById(userId).get();
		
	}

}