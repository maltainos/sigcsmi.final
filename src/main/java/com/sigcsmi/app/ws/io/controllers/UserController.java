package com.sigcsmi.app.ws.io.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sigcsmi.app.ws.io.models.UserEntity;
import com.sigcsmi.app.ws.service.UserService;

@Controller
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity userDetails) {
		System.out.println("POST USER");
		if(userDetails == null) throw new RuntimeException("The object cannot null");
		
		return userService.createUser(userDetails);
	}

}
