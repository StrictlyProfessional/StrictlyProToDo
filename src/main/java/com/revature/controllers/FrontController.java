package com.revature.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.beans.Workout;
import com.revature.services.ExerciseServiceImpl;
import com.revature.services.UserServiceImpl;
import com.revature.services.WorkoutServiceImpl;

@RestController
@RequestMapping(path = "/strictly")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:8080")
public class FrontController {
	
	private UserServiceImpl us;
	private WorkoutServiceImpl ws;
	
	@Autowired
	public FrontController(UserServiceImpl us, WorkoutServiceImpl ws ) {
		this.us = us;
		this.ws = ws;
	}
	
	/**************GET*********************/
	// All Users
	@GetMapping(produces = "application/json", path = "/users")
	public ArrayList<User> getAllUsers() {
		return us.getAll();
	}
	
	// All Workouts
	@GetMapping(produces = "application/json", path = "/workouts")
	public ArrayList<Workout> getAllWorkouts() {
		return ws.getAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*************POST*******************/
	// User Login
	@PostMapping(produces = "application/json", path = "/user-login", consumes= "application/json")
	public User loginUser(@RequestBody User u) {
		System.out.println("this is req" + u);
		return us.login(u.getUsername(), u.getPassword());
	}
	
}
