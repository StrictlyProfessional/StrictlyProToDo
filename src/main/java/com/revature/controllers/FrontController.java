package com.revature.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserServiceImpl;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:8080")
public class FrontController {
	
	private UserServiceImpl us;
	
	@Autowired
	public FrontController(UserServiceImpl us) {
		this.us = us;
	}
	
	@GetMapping(produces = "application/json")
	public ArrayList<User> getAllUsers() {
		return us.getAll();
	}
	
}
