package com.michaeljgoerlitz.fitnesstracker.repository;

import com.michaeljgoerlitz.fitnesstracker.model.Meal;
import org.springframework.data.repository.ListCrudRepository;

public interface MealRepository extends ListCrudRepository<Meal, Integer> {
}
