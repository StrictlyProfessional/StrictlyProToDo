package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.CustomExercise;

@Repository
public interface CustomExerciseRepo extends CrudRepository<CustomExercise, Integer>{

}