package exercise;

// Use Case

public class ExerciseManager {

    /**
     * Create a new exercise
     * @param name The name of the new exercise
     * @param caloriesBurntPerMin The number of calories burnt per minute while engaging in the new exercise
     * @return The created Exercise
     */
    public Exercise createExercise(String name, double caloriesBurntPerMin) {
        if (name.equals("_")) {
            throw new IllegalArgumentException ("An exercise cannot be named _");
        }
        return new Exercise(name, caloriesBurntPerMin);
    }

    /**
     * Delete the passed exercise
     * @param toBeDeleted The exercise that will be deleted
     * @return Whether the exercise was deleted
     */
    public boolean deleteExercise(Exercise toBeDeleted) {
        toBeDeleted.setName("_");
        return true;
    }
}
