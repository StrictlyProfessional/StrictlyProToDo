package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Exercise;

@Repository
public interface ExerciseRepo extends CrudRepository<Exercise, Integer>{

}
