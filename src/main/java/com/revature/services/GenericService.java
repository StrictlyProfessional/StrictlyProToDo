package com.revature.services;

import java.util.ArrayList;

import com.revature.beans.User;

public interface GenericService<t> {
	public t getById(int id);

	public ArrayList<t> getAll();

	public t add(t u);

	public t update(t u);

	public boolean delete(int id);

}
