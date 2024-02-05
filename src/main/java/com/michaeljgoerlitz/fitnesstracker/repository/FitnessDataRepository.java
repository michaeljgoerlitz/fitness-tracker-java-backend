package com.michaeljgoerlitz.fitnesstracker.repository;

import com.michaeljgoerlitz.fitnesstracker.model.FitnessData;
import org.springframework.data.repository.ListCrudRepository;

public interface FitnessDataRepository extends ListCrudRepository<FitnessData, Integer> {
}
