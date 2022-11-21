package controllers;

// Interface adapters

import use_cases.ExerciseInputBoundary;

public class ExerciseCreationController {
    final ExerciseInputBoundary exerciseInputBoundary;

    /**
     * Constructor
     * @param eib The use case needed to create exercises
     */
    public ExerciseCreationController(ExerciseInputBoundary eib) {
        this.exerciseInputBoundary = eib;
    }

    /**
     * Create a new exercise
     * @param name The name of the new exercise
     * @param calories The number of calories burnt per minutes
     * @return Return whether the exercise is created
     */
    public boolean create(String name, double calories) {
        return exerciseInputBoundary.create(name, calories);
    }

}
