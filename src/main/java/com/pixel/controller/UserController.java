package com.pixel.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;

//////////////////////////////////////////////////////
/////                PIXEL PROJECT    ///////////////
//////////////////////////////////////////////////////

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pixel.model.User;
import com.pixel.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

   

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user) {
        return userService.save(user);
    }
   
    
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public User findAllUser(@RequestBody User user) {
        return (User) userService.findAllUsers();
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String>json) throws ServletException {
		
    	if(json.get("username")==null||json.get("password")==null){
    		System.out.println("Nothing correct");
    		throw new ServletException("Please fill in username and password!");
    	}
    	
    	String username = json.get("username");
    	String password = json.get("password");
    	
    	
    	User user = userService.findByUserName(username);
    	
    	if(user==null){
    		System.out.println("No User found");
    		throw new ServletException("No User Found");
    	}
    	String pass = user.getPassword();
    	
    	if (!pass.equals(password)){
    		System.out.println("Password Incorrect");
    		throw new ServletException("Password Incorrect!");
    		
    	}
    	
    	System.out.println("Almost Logged In!!!");
    	
    	return Jwts.builder().setSubject(username).claim("roles", "user")
    			.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        
    }
    
    

}
