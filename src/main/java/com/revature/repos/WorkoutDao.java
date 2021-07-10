package com.revature.repos;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.beans.Workout;

public class WorkoutDao {
	private DataSource dataSource;

	public void setRowMapper(DataSource ds) {
		dataSource = ds;
	}
	
	@SuppressWarnings("deprecation")
	public Workout getWorkoutByUser(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String query = "select * from workouts join exercises on exercises.id = ANY (workouts.exercise_ids) where user_id = ?;";
		Workout workout = jdbcTemplate.queryForObject(query, new Object[] { id }, new WorkoutRowMapper());
		System.out.println("WorkoutDao" + workout);
		return workout;
	}
	
}
