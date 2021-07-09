package com.revature.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.beans.User;
import com.revature.beans.Workout;
import com.revature.repos.UserRepo;
import com.revature.repos.WorkoutRepo;
import com.revature.services.GenericService;
import com.revature.services.UserServiceImpl;
import com.revature.services.WorkoutServiceImpl;

@SpringBootTest
class StrictlyProToDoApplicationTests {
	private UserRepo ur;
	private WorkoutRepo wr;
	
	GenericService<User> us = new UserServiceImpl(ur);
	GenericService<Workout> ws = new WorkoutServiceImpl(wr);
	
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllUsers() {
		System.out.println(us.getAll());
	}
	
	@Test
	void getAllWorkouts() {
		System.out.println(ws.getAll());
	}

}
