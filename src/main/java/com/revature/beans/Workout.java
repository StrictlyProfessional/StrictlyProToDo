package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "workouts")
@Table(name = "workouts")
public class Workout {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "workout_exercise_map", joinColumns = @JoinColumn(name = "workout_map"), inverseJoinColumns = @JoinColumn(name = "exercise_map"))
	private List<Exercise> exercises = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "workout_customexercise_map", joinColumns = @JoinColumn(name = "workout_map"), inverseJoinColumns = @JoinColumn(name = "customexercise_map"))
	private List<CustomExercise> customExercises = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "workout_customexercise_map", joinColumns = @JoinColumn(name = "workout_map"), inverseJoinColumns = @JoinColumn(name = "customexercise_map"))
	private List<Integer> indexs = new ArrayList<>();
	
	@Transient
	private ArrayList<Object> combinedExercises;

	public Workout() {
		super();
	}

	public Workout(int id, User user, String name, List<Exercise> exercises, List<CustomExercise> customExercises,
			ArrayList<Object> combinedExercises) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.exercises = exercises;
		this.customExercises = customExercises;
		this.combinedExercises = combinedExercises;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	public List<CustomExercise> getCustomExercises() {
		return customExercises;
	}

	public void setCustomExercises(List<CustomExercise> customExercises) {
		this.customExercises = customExercises;
	}

	public ArrayList<Object> getCombinedExercises() {
		return combinedExercises;
	}

	public void setCombinedExercises(ArrayList<Object> combinedExercises) {
		this.combinedExercises = combinedExercises;
	}
	
	public void combineExercises() {
		if(this.customExercises.isEmpty() || this.exercises.isEmpty()) {
			System.out.println("This workout has either an empty customexercises array or default exercises array");
		} else {
			for (Exercise e : this.exercises) {
				this.combinedExercises.add(e);
			}
			for (CustomExercise ce : this.customExercises) {
				this.combinedExercises.add(ce);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((combinedExercises == null) ? 0 : combinedExercises.hashCode());
		result = prime * result + ((customExercises == null) ? 0 : customExercises.hashCode());
		result = prime * result + ((exercises == null) ? 0 : exercises.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Workout other = (Workout) obj;
		if (combinedExercises == null) {
			if (other.combinedExercises != null)
				return false;
		} else if (!combinedExercises.equals(other.combinedExercises))
			return false;
		if (customExercises == null) {
			if (other.customExercises != null)
				return false;
		} else if (!customExercises.equals(other.customExercises))
			return false;
		if (exercises == null) {
			if (other.exercises != null)
				return false;
		} else if (!exercises.equals(other.exercises))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", user=" + user + ", name=" + name + ", exercises=" + exercises
				+ ", customExercises=" + customExercises + ", combinedExercises=" + combinedExercises + "]";
	}

}
