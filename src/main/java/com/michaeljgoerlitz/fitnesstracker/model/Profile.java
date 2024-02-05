package com.michaeljgoerlitz.fitnesstracker.model;

import org.springframework.data.annotation.Id;

public record Profile(
        @Id
        Integer id,
        String username,
        Integer calorieGoal
) {
}
