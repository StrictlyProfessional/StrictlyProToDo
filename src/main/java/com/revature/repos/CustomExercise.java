package com.revature.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomExercise extends CrudRepository<CustomExercise, Integer>{

}