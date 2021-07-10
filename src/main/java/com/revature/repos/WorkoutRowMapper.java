package com.revature.repos;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.revature.beans.Exercise;
import com.revature.beans.Workout;
import com.revature.services.ExerciseServiceImpl;
import com.revature.services.UserServiceImpl;

public class WorkoutRowMapper implements RowMapper<Workout> {
	
	private UserServiceImpl us;
	private ExerciseServiceImpl es;

	@Autowired
	public WorkoutRowMapper(UserServiceImpl us, ExerciseServiceImpl es) {
		this.us = us;
		this.es = es;
	}

	public WorkoutRowMapper() {
		super();
	}

	@Override
	public Workout mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArrayList<Exercise> exercises = new ArrayList<>();
		Array exerciseids = rs.getArray("eids");
		Integer[] eids = (Integer[])exerciseids.getArray();
		Workout w = new Workout();
		int userId = rs.getInt("user_id");
		
		w.setId(rs.getInt("id"));
		w.setName(rs.getString("name"));
		w.setUser(us.getById(userId));
		
		// grabbing exercises
		for (int i = 0; i < eids.length; i++) {
			exercises.add(es.getById(eids[i]));
		}
		
		w.setExercises(exercises);
		
		
		return w;
	}

}
