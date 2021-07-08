package com.revature.main;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.beans.User;
import com.revature.repos.UserRepo;
import com.revature.services.GenericService;
import com.revature.services.UserServiceImpl;

@SpringBootTest
class StrictlyProToDoApplicationTests {
	private UserRepo ur;
	
	GenericService<User> us = new UserServiceImpl(ur);
	
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllUsers() {
		System.out.println(us.getAll());
	}

}
