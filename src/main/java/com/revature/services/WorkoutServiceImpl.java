package com.revature.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Workout;
import com.revature.repos.WorkoutRepo;

@Service
public class WorkoutServiceImpl implements GenericService<Workout> {
	
	private WorkoutRepo wr;
	
	@Autowired
	public WorkoutServiceImpl(WorkoutRepo wr) {
		this.wr= wr;
	}

	@Override
	public Workout getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Workout> getAll() {
		return (ArrayList<Workout>) wr.findAll();
	}

	@Override
	public Workout add(Workout u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Workout update(Workout u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
