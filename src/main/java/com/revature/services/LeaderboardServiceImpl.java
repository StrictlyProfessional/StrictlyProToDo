package com.revature.services;




import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repos.LeaderboardRepo;

@Service
public class LeaderboardServiceImpl implements GenericService<User>{
	private UserServiceImpl us;
	
	private LeaderboardRepo lr;
	
	@Autowired
	public LeaderboardServiceImpl(LeaderboardRepo lr, UserServiceImpl us) {
		this.lr = lr;
		this.us = us;
	}
	class SortByExperience implements Comparator<User>{

		@Override
		public int compare(User u1, User u2) {
			// TODO Auto-generated method stub
			return u2.getExperience() - u1.getExperience();
		}
		
	}
	public User[] getLeaderboard() throws SQLException{
		ArrayList<User> users = new ArrayList<>();
		ArrayList<User> unsortedUsers = (us.getAll());
		User[] arr = unsortedUsers.toArray(new User[0]);
		Arrays.sort(arr, new SortByExperience());
		return arr;

	}
	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User add(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User update(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

