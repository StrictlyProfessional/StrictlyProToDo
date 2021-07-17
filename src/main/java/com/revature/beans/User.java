package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "users")
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String username;
	private String password;

	@Column(name = "user_level")
	private int userLevel;

	private int experience;

	@JsonManagedReference
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<CustomExercise> customExercises = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Workout> workouts = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String username, String password, int userLevel, int experience,
			List<CustomExercise> customExercises, List<Workout> workouts) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userLevel = userLevel;
		this.experience = experience;
		this.customExercises = customExercises;
		this.workouts = workouts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public List<CustomExercise> getCustomExercises() {
		return customExercises;
	}

	public void setCustomExercises(List<CustomExercise> customExercises) {
		this.customExercises = customExercises;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customExercises == null) ? 0 : customExercises.hashCode());
		result = prime * result + experience;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userLevel;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((workouts == null) ? 0 : workouts.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (customExercises == null) {
			if (other.customExercises != null)
				return false;
		} else if (!customExercises.equals(other.customExercises))
			return false;
		if (experience != other.experience)
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userLevel != other.userLevel)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (workouts == null) {
			if (other.workouts != null)
				return false;
		} else if (!workouts.equals(other.workouts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userLevel=" + userLevel
				+ ", experience=" + experience + ", customExercises=" + customExercises + ", workouts=" + workouts
				+ "]";
	}

}
