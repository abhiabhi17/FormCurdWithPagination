package com.example.jpa;



import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.example.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	
	 @Transactional
	  @Modifying
	@Query("update User set activesw='false' where userId=:userId")
	

	public void delete(Integer userId);

	
@Query(value="select email from User")
public	ArrayList<String> findAllEmails();


@Query(value="SELECT email from User WHERE user_id=:uid",nativeQuery=true)
public String findEmailById(Integer uid);


	

	

}
