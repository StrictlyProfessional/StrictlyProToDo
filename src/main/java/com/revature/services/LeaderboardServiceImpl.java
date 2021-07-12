package com.revature.services;




import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.User;
import com.revature.repos.LeaderboardRepo;


public class LeaderboardServiceImpl implements GenericService<User>{
	private UserServiceImpl us;
	
	private LeaderboardRepo lr;
	
	@Autowired
	public LeaderboardServiceImpl(LeaderboardRepo lr) {
		this.lr = lr;
	}
	class SortByExperience implements Comparator<User>{

		@Override
		public int compare(User u1, User u2) {
			// TODO Auto-generated method stub
			return u1.getExperience() - u2.getExperience();
		}
		
	}
	public ArrayList<User> getLeaderboard() throws SQLException{
		ArrayList<User> users = new ArrayList<>();
		ArrayList<User> unsortedUsers = (us.getAll());
		User[] arr = unsortedUsers.toArray(new User[0]);
		Arrays.sort(arr, new SortByExperience());
		List<User> ul = new ArrayList<User>(Arrays.asList(arr));
		users = (ArrayList<User>) ul;
		//remove this
		System.out.println(users);
		return users;
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

