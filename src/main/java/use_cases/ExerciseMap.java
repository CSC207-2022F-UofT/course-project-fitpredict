package use_cases;

// Use Case

import entities.CurrentUser;
import entities.Exercise;

import java.util.ArrayList;
import java.util.HashMap;


public class ExerciseMap {
    // Static because otherwise it would be redundant, each user's Exercise map instance would only contain themselves
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
    public static ArrayList<Exercise> get(String userName) {
        return exerciseMap.get(userName);
    }

    /**
     * Adds a new exercise to the exercise array of the passed user
     * @param newExercise The new exercise to be added
     */
    public static void addExercise (Exercise newExercise) {
        // If this is the user's first exercise, creates a new key/value pair
        String name = CurrentUser.getInstance().getUser().getUsername();
        if (exerciseMap.containsKey(name)) {
            exerciseMap.get(name).add(newExercise);
        }
        else {
            exerciseMap.put(name, new ArrayList<>());
            exerciseMap.get(name).add(newExercise);
        }
    }
}
