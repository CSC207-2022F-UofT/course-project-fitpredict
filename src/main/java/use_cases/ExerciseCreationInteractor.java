package use_cases;

// Use Case

import entities.CurrentUser;
import entities.Exercise;
import screens.ResultScreen;
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
        if (ExerciseMap.contains(CurrentUser.getInstance().getUsername())) {
            ArrayList<Exercise> exerciseList = ExerciseMap.get(CurrentUser.getInstance().getUsername());
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
