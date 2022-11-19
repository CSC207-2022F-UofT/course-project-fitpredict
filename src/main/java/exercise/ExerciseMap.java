package exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class ExerciseMap {
    private static final HashMap<String, ArrayList<Exercise>> exerciseMap = new HashMap<>();

    public ExerciseMap() {
    }

    public boolean contains(String search) {
        return exerciseMap.containsKey(search);
    }

    public ArrayList<Exercise> get(String userName) {
        return exerciseMap.get(userName);
    }

    /**
     * Adds a new exercise to the current user's ArrayList of exercises
     * Returns the new exercise added
     */
    public void addExercise (User currentUser, Exercise newExercise) {
        String name = currentUser.getName();
        if (exerciseMap.containsKey(name)) {
            exerciseMap.get(name).add(newExercise);
        }
        else {
            exerciseMap.put(name, new ArrayList<>());
            exerciseMap.get(name).add(newExercise);
        }
    }
}
