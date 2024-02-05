package com.michaeljgoerlitz.fitnesstracker.model;

public record Profile(
        Integer id,
        String username,
        Integer calorieGoal
) {
}
