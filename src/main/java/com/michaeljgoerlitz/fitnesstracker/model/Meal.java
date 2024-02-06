package com.michaeljgoerlitz.fitnesstracker.model;

import org.springframework.data.annotation.Id;

public record Meal(
        @Id
        Integer id,
        Integer profileId,
        String date,
        Integer caloriesInMeal,
        MealType typeOfMeal
) {
}
