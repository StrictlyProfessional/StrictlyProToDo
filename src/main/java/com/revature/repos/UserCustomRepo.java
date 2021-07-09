package com.revature.repos;

import com.revature.beans.User;

public interface UserCustomRepo {
	public User login(String username, String password);
}
