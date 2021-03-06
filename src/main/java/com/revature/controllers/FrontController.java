package com.revature.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin(origins = {"https://localhost:4200/", "http://strictly-pro-client.s3-website-us-east-1.amazonaws.com/"})
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
	
	// update user
	@PostMapping(produces = "application/json", consumes= "application/json", path="/users/update")
	public User updateUser(@RequestBody User u) {
		return us.update(u);
	}
			
	// Hector's - Get all Exercises
	@GetMapping(produces="application/json", path = "/exercises")
	public ArrayList<Exercise> getAllExercises() {
		return es.getAll();
	}
	
	// Matt's - Add a Custom Exercise
	@PostMapping(produces = "application/json", consumes= "application/json", path="/exercises/add")
	public Exercise addExercise(@RequestBody Exercise fresh) {
		return es.add(fresh);
	}
	
	// Hector's - Get all Custom Exercises
	@GetMapping(produces="application/json", path = "/customExercises")
	public ArrayList<CustomExercise> getAllCustomExercises() {
		return ces.getAll();
	}
	
	// Hector's - Add a Custom Exercise
	@PostMapping(produces = "application/json", consumes= "application/json", path="/customExercises/add")
	public CustomExercise addCustomExercise(@RequestBody CustomExercise fresh) {
		return ces.add(fresh);
	}
	

	@PostMapping(produces = "application/json", consumes= "application/json", path = "/customExercises/update")
	public CustomExercise updateCustomExercise(@RequestBody CustomExercise ce) {
		System.out.println("Editing exercise: " + ce);
		return ces.update(ce);
	}
	
	@PostMapping(produces = "application/json", consumes= "application/json", path="/customExercises/delete/{id}")
	public boolean deleteCustomExercise(@PathVariable("id") int id) {
		return ces.delete(id);
	}
	
	// All Workouts
	@GetMapping(produces = "application/json", path = "/workouts")
	public ArrayList<Workout> getAllWorkouts() {
		return ws.getAll();
	}
	
	// get workout by id
	@GetMapping(produces = "application/json", path = "/workouts/{id}")
	public Workout getWorkoutById(@PathVariable("id") int id) {
		return ws.getById(id);
	}
	
	// add workout
	@PostMapping(produces = "application/json", consumes= "application/json", path="/workouts/add")
	public Workout add(@RequestBody Workout w) {
		return ws.add(w);
	}
	
	// update workout
	@PostMapping(produces = "application/json", consumes= "application/json", path="/workouts/update")
	public Workout update(@RequestBody Workout w) {
		return ws.update(w);
	}
	
	// delete workout
	@PostMapping(consumes="application/json", produces="application/json", path="/workouts/delete")
	public void delete(@RequestBody Workout w) {
		ws.delete(w.getId());
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
	
	// User Register
	@PostMapping(produces = "application/json", path = "/register", consumes = "application/json")
	public User registerUser(@RequestBody User u) {
		System.out.println("Registering user: " + u);
		return us.add(u);
	}
	
}