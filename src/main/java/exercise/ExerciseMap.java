package exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class ExerciseMap {
    private final HashMap<String, ArrayList<Exercise>> exerciseMap = new HashMap<String, ArrayList<Exercise>>();

    /**
     * Adds a new exercise to the current user's ArrayList of exercises
     * Returns the new exercise added
     */
    public Exercise addExercise (User currentUser, Exercise newExercise) {
        String name = currentUser.getName();
        if (exerciseMap.containsKey(name)) {
            exerciseMap.get(name).add(newExercise);
        }
        else {
            exerciseMap.put(name, new ArrayList<Exercise>());
            exerciseMap.get(name).add(newExercise);
        }
        return newExercise;
    }
}
