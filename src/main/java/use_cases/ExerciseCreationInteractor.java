package use_cases;

// Use Case

import entities.CurrentUser;
import entities.Exercise;
import java.util.ArrayList;

public class ExerciseCreationInteractor implements ExerciseInputBoundary {
    final ExerciseManager manager;

    /**
     * Constructor
     * @param manager Used to create exercises
     */
    public ExerciseCreationInteractor (ExerciseManager manager) {
        this.manager = manager;
    }

    /**
     * Creates and assigns a new exercise to the currently logged in user
     * @param name The name of the new exercise
     * @param caloriesBurntPerMin The number of calories burnt per minute while engaging in the new exercise
     * @return Returns a boolean representing if the exercise was successfully created
     */
    @Override
    public boolean create(String name, double caloriesBurntPerMin) {
        // Checks if the user exists as a key in the ExerciseMap, if it exists and the user already has an exercise
        // named name, the new exercise is not created and false is returned.
        if (ExerciseMap.contains(CurrentUser.getInstance().getUser().getUsername())) {
            ArrayList<Exercise> exerciseList = ExerciseMap.get(CurrentUser.getInstance().getUser().getUsername());
            for (Exercise exercise : exerciseList) {
                if (exercise.getName().equals(name)) {
                    return false;
                }
            }
        }
        ExerciseMap.addExercise(manager.createExercise(name, caloriesBurntPerMin));
        return true;
    }
}
