package com.michaeljgoerlitz.fitnesstracker.model;

import org.springframework.data.annotation.Id;

public record Workout(
        @Id
        Integer id,
        Integer profileId,
        String date,
        Integer numOfMinutes,
        WorkoutType typeOfWorkout,
        Integer caloriesBurned
) {
}
