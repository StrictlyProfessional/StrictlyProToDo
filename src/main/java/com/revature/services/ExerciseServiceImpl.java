package com.revature.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Exercise;
import com.revature.repos.ExerciseRepo;

public class ExerciseServiceImpl implements GenericService<Exercise> {

	private ExerciseRepo er;
	
	@Autowired
	public ExerciseServiceImpl(ExerciseRepo er) {
		this.er = er;
	}
	
	@Override
	public Exercise getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Exercise> getAll() {
		return null;
	}

	@Override
	public Exercise add(Exercise u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exercise update(Exercise u) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
