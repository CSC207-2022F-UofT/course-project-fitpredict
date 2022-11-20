package exercise;

// Use Case

public interface ExerciseInputBoundary {
    /**
     * Create a new exercise
     * @param name The name of the new exercise
     * @param caloriesBurntPerMin The number of calories burnt per minute while engaging in the new exercise
     * @return Whether or not the exercise was created
     */
    boolean create(String name, double caloriesBurntPerMin);
}
