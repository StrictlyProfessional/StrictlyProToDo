package com.revature.repos;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.User;

public interface LeaderboardRepo extends CrudRepository<User,Integer>{
	
}
