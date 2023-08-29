package com.example.controllers;



import java.util.ArrayList;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.appproperties.AppProperties;
import com.example.constants.AppConstants;
import com.example.jpa.UserRepository;
import com.example.pojo.User;
import com.example.pojo.UserEntity;
import com.example.service.UserService;


@Controller
public class UserController {

	

	@Autowired
	private UserService service;
	
	
	@Autowired
	@Qualifier("app")
	private AppProperties props;
	
	
	@Autowired
	private UserRepository  userRepo;
	/**
	 * This method is used to load user reg form
	 * 
	 * @param model
	 * @return String
	 
	 */
	
	
	
	
	
//====================================FORM LOADING=======================================================//
	
	
	@RequestMapping(value = AppConstants.REQ_URL)
	public String loadForm(Model model) {
		
	
		formValues(model);
		
		return AppConstants.DISPLAY_USERS_VIEW;
	}

	

	private void formValues(Model model) {
		User userObj = new User();
		model.addAttribute("user", userObj);
		model.addAttribute("countryList",service.getCountries());
		
	}


//==========================REGISTER USER===============================================//
	
	
	@RequestMapping(value = AppConstants.REQ_URL, method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, Model model) {
		System.out.println(user);
		
		
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		model.addAttribute("users", service.save(user));
		
		model.addAttribute("countryList",service.getCountries());
		
		
		
		String successMsg=props.getProps().get("register-success");
		
		
		model.addAttribute("succMsg", successMsg);
		return "redirect:/registerUser";
	}
	
	//===============================VIEW USERS(PAGINATION)==============================================================//
	
	
	@RequestMapping(value="/viewUsers")
	public String usersList(Model model,@ModelAttribute("user") User user,@RequestParam("pn") Integer currentPageNo)
	{
		
		Integer pageSize=3;
		PageRequest page =PageRequest.of(currentPageNo-1, pageSize);
		   List<User> pageData =  service.getAllUsers(page);
		
		   Page<User> PageData = userRepo.findAll(page);
		     List<User> users= PageData.getContent();
		            int totalPages = PageData.getTotalPages();
		
		
		  
	           model.addAttribute("tp", totalPages);
	           model.addAttribute("cp", currentPageNo);
		
	        model.addAttribute("userList", pageData);
	        
		return AppConstants.DISPLAY_USERS_LIST;
	}
	
	//======================================DELETE USER (byID)===========================================================//
	
	
	
	
	
	/*
	 * @RequestMapping("/deleteUser") public String
	 * deleteUserById(@RequestParam("userId") Integer userId) {
	 * 
	 * service.delete(userId); return "redirect:viewUsers?pn=1"; }
	 */
	 
	
	
	
	//===========================================================EDIT USER========================================================//
	 
	 
	//======================================SOFTDELETE USER (byID)===========================================================//
	
	
	
	  @RequestMapping(value="/deleteUser") 
	  public String deleteBook(HttpServletRequest req,Model model) 
	  { 
		  boolean isDeleted = false;
	  String uid = req.getParameter("userId"); 
	  if (uid != null &&!uid.equals("")) 
	  {
	  int userId = Integer.parseInt(uid);
	  
	  isDeleted = service.softDelete(userId); if (isDeleted) {
	  model.addAttribute("sMsg","Deleted Successfully..");
	  
	  } else {
	  
	  model.addAttribute("eMsg", "Failed to deleted.."); }
	  
	  
	  } 
	  
	  return "redirect:viewUsers?pn=1";
	  
	  }
	 
	 
	 
	 
	
	
	
	
	
		 
		
		
		
		//===========================================================EDIT USER========================================================//
	 
	 @RequestMapping("/editUser")
		public String editUser(Model model,@RequestParam("userId") Integer userId,@ModelAttribute("user") User user)
		{
			User users =service.findById(userId);
			model.addAttribute("user", users);
			
			model.addAttribute("countryList",service.getCountries());
			
		
		
			return AppConstants.DISPLAY_USERS_EDIT_VIEW;
		}
	 
	 
	 //========================================UPDATE USER======================================================================//
	 
	 
		@RequestMapping(value ="/updateUser", method = RequestMethod.POST)
	 public String updateUser(@RequestParam("userId") Integer userId, Model model,@ModelAttribute("user") User user)
	 {
		/*
		 * UserEntity userEntity=new UserEntity(); BeanUtils.copyProperties(user,
		 * userEntity);
		 */
		 
			
		model.addAttribute("users", service.save(user));
		
		String updateSuccess=props.getProps().get("update-success");
		
	
		model.addAttribute("succMsg", updateSuccess);
		return AppConstants.DISPLAY_USERS_VIEW;
	 }
		
//=====================================GetEmails(CUSTOM QUERY)========================================================================//
		
		
		@RequestMapping(value="/getEmails")
	public @ResponseBody ArrayList<String> findAllUsersEmail()
	{
		return service.findAllEmails();
		
	

	}
		
		
		@RequestMapping(value="/getEmail")
		public @ResponseBody String findEmailById(@RequestParam("uid") Integer userId)
		{
			return service.findEmailById(userId);
		}
		
}
