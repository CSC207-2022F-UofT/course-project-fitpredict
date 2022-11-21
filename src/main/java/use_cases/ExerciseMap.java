package use_cases;

// Use Case

import entities.Exercise;

import java.util.ArrayList;
import java.util.HashMap;


public class ExerciseMap {
    private static final HashMap<String, ArrayList<Exercise>> exerciseMap = new HashMap<>();

    /**
     * Constructor
     */
    public ExerciseMap() {
    }

    /**
     * Checks if the exercise map contains a user
     * @param search The name of the user to be searched for
     * @return Whether the user exists in the exercise map
     */
    public static boolean contains(String search) {
        return exerciseMap.containsKey(search);
    }

    /**
     * Gets the exercise array correlated to the passed user
     * @param userName The name of the user who we want to get the exercise array from
     * @return The exercise array of the passed user
     */
    public ArrayList<Exercise> get(String userName) {
        return exerciseMap.get(userName);
    }

    /**
     * Adds a new exercise to the exercise array of the passed user
     * @param currentUser The user who is creating a new exercise
     * @param newExercise The new exercise to be added
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
