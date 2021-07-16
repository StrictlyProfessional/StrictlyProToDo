package com.revature.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.CustomExercise;
import com.revature.repos.CustomExerciseRepo;

@Service
public class CustomExerciseImpl implements GenericService<CustomExercise> {

	private CustomExerciseRepo cer;
	
	@Autowired
	public CustomExerciseImpl(CustomExerciseRepo cer) {
		this.cer = cer;
	}
	
	@Override
	public CustomExercise getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CustomExercise> getAll() {
		return (ArrayList<CustomExercise>) cer.findAll();
	}

	@Override
	public CustomExercise add(CustomExercise u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomExercise update(CustomExercise u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
