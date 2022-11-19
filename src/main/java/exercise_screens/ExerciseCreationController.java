package exercise_screens;

import exercise.ExerciseInputBoundary;

public class ExerciseCreationController {
    final ExerciseInputBoundary eib;

    public ExerciseCreationController(ExerciseInputBoundary eib) {
        this.eib = eib;
    }

    public boolean create(String name, double calories) {
        return eib.create(name, calories);
    }

}
