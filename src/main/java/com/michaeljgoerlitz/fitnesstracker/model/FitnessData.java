package com.michaeljgoerlitz.fitnesstracker.model;

import org.springframework.data.annotation.Id;

public record FitnessData(
        @Id
        Integer id,
        Integer profileId,
        String date,
        Integer totalCalories,
        Integer caloriesBurned
) {
}
