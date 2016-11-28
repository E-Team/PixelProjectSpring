package com.pixel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pixel.model.User;
import com.pixel.service.UserService;

@RestController
@RequestMapping("/services")
public class UserServicesController {
	
	
	@Autowired
	private UserService userService;
	
	 @RequestMapping("/user/users")
	    public List<User> findAllUsers() {
	        return userService.findAllUsers();
	    }
	 
	 @RequestMapping(value = "/user/userName", method = RequestMethod.POST)
	    public User findByUserName(@RequestBody String userName) {
	        return userService.findByUserName(userName);
	    }
	 @RequestMapping(value = "/user/userId", method = RequestMethod.POST)
	    public User findByUserName(@RequestBody Long userId) {
	        return userService.findByUserId(userId);
	    }

	    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
	    public User updateUser(@RequestBody User user) {
	    	System.out.println("UPDATE DONE ON USER!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    	return userService.save(user);
	    }

	

}
