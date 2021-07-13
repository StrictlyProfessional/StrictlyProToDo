package com.revature.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repos.UserRepo;

@Service
public class UserServiceImpl implements GenericService<User> {
	
	private UserRepo ur;
	
	@Autowired
	public UserServiceImpl(UserRepo ur) {
		this.ur = ur;
	}

	@Override
	public User getById(int id) {
		return ur.findById(id).get();
	}

	@Override
	public ArrayList<User> getAll() {
		return (ArrayList<User>) ur.findAll(); 
	}

	@Override
	public User add(User u) {
		return ur.save(u);
	}

	@Override
	public User update(User u) {
		return ur.save(u);
	}
	
	public User login(String username, String password) {
		User u = ur.login(username, password);
		if(u == null) {
			return null;
		} else {
			return u;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			ur.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
