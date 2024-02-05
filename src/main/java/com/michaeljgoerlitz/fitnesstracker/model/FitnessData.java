package com.michaeljgoerlitz.fitnesstracker.model;

public record FitnessData(
        Integer id,
        Integer profileId,
        String date,
        Integer totalCalories,
        Integer caloriesBurned
) {
}
