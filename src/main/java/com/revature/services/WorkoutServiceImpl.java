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
		return wr.findById(id).get();
	}

	@Override
	public ArrayList<Workout> getAll() {
		return (ArrayList<Workout>) wr.findAll();
	}

	@Override
	public Workout add(Workout u) {
		return wr.save(u);
	}

	@Override
	public Workout update(Workout u) {
		return wr.save(u);
	}

	@Override
	public boolean delete(int id) {
		try {
			wr.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
