package com.example.rest;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.UserRepository;
import com.example.pojo.User;
import com.example.pojo.UserEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api
@RestController
public class UserRestController {
	
	@Autowired
	private UserRepository userRepo;

	@ApiOperation("This Method is Used for finding books")
	@ApiResponse(response=String.class,message="String Value",code=200) 
	
	@GetMapping(value="/get",produces= {"application/json","application/xml"})
	public User getUserById(@RequestParam("uid") Integer userId)
	{
		UserEntity entity=new UserEntity();
		Optional<User> opt=userRepo.findById(userId);
		User user=opt.get();
		BeanUtils.copyProperties(user, entity);
		return user;
		
	}
}
