package com.michaeljgoerlitz.fitnesstracker.repository;

import com.michaeljgoerlitz.fitnesstracker.model.Workout;
import org.springframework.data.repository.ListCrudRepository;

public interface WorkoutRepository extends ListCrudRepository<Workout, Integer> {
}
