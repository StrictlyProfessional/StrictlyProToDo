package com.revature.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.CustomExercise;
import com.revature.beans.Exercise;
import com.revature.beans.User;
import com.revature.beans.Workout;
import com.revature.repos.LeaderboardRepo;
import com.revature.services.CustomExerciseImpl;
import com.revature.services.ExerciseServiceImpl;
import com.revature.services.LeaderboardServiceImpl;
import com.revature.services.UserServiceImpl;
import com.revature.services.WorkoutServiceImpl;

@RestController
@RequestMapping(path = "/strictly")
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200")
public class FrontController {
	
	private UserServiceImpl us;
	private WorkoutServiceImpl ws;
	private LeaderboardServiceImpl ls;
	private ExerciseServiceImpl es;
	private CustomExerciseImpl ces;
	
	@Autowired
	public FrontController(UserServiceImpl us, WorkoutServiceImpl ws, LeaderboardServiceImpl ls, ExerciseServiceImpl es, CustomExerciseImpl ces) {
		this.us = us;
		this.ws = ws;
		this.ls = ls;
		this.es = es;
		this.ces = ces;
	}
	
	/**************GET*********************/
	// All Users
	@GetMapping(produces = "application/json", path = "/users")
	public ArrayList<User> getAllUsers() {
		return us.getAll();
	}
	
	// Hector's - Get a specific User
	@GetMapping(produces = "application/json", path = "/users/{id}")
	public User DiscoverygetUserById(@PathVariable("id") int id) {
		return us.getById(id);
	}
			
	// Hector's - Get all Exercises
	@GetMapping(produces="application/json", path = "/exercises")
	public ArrayList<Exercise> getAllExercises() {
		return es.getAll();
	}
	
	// Hector's - Get all Custom Exercises
	@GetMapping(produces="application/json", path = "/customExercises")
	public ArrayList<CustomExercise> getAllCustomExercises() {
		return ces.getAll();
	}
	
	// All Workouts
	@GetMapping(produces = "application/json", path = "/workouts")
	public ArrayList<Workout> getAllWorkouts() {
		return ws.getAll();
	}
	
	//Leaderboard
	@GetMapping(produces ="application/json",path ="/leaderboard")
	public User[] getLeaderboard() throws SQLException{
		return ls.getLeaderboard();
	}
	
	@GetMapping(produces ="application/json",path ="/vault/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return us.getById(id);
	}
	
	/*************POST*******************/
	// User Login
	@PostMapping(produces = "application/json", path = "/user-login", consumes= "application/json")
	public User loginUser(@RequestBody User u) {
		System.out.println("this is req" + u);
		return us.login(u.getUsername(), u.getPassword());
	}
	
}