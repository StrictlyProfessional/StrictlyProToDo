package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "workouts")
@Table(name = "workouts")
public class Workout {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@Column(name = "user_id")
	@ManyToOne
	@JoinColumn(name = "username")
	private User user_id;
	private String name;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "name")
	private List<Exercise> exercise_ids;

	public Workout() {
		super();
	}

	public Workout(int id, User userId, String name, ArrayList<Exercise> eids) {
		super();
		this.id = id;
		this.user_id = userId;
		this.name = name;
		this.exercise_ids = eids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return user_id;
	}

	public void setUserId(User userId) {
		this.user_id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Exercise> getEids() {
		return exercise_ids;
	}

	public void setEids(ArrayList<Exercise> eids) {
		this.exercise_ids = eids;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercise_ids == null) ? 0 : exercise_ids.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		if (exercise_ids == null) {
			if (other.exercise_ids != null)
				return false;
		} else if (!exercise_ids.equals(other.exercise_ids))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", userId=" + user_id + ", name=" + name + ", eids=" + exercise_ids + "]";
	}

}
