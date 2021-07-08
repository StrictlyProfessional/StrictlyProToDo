package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
	@Column(name = "user_id")
	@JoinColumn(name = "username")
	private int userId;
	private String name;
	@Column(name = "exercise_ids")
	@JoinColumn(name = "exercise_name")
	@ElementCollection(targetClass = Integer.class)
	private List<Integer> eids;

	public Workout() {
		super();
	}

	public Workout(int id, int userId, String name, ArrayList<Integer> eids) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.eids = eids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getEids() {
		return eids;
	}

	public void setEids(ArrayList<Integer> eids) {
		this.eids = eids;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eids == null) ? 0 : eids.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + userId;
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
		if (eids == null) {
			if (other.eids != null)
				return false;
		} else if (!eids.equals(other.eids))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", userId=" + userId + ", name=" + name + ", eids=" + eids + "]";
	}

}
