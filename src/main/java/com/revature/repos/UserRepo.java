package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	
}
