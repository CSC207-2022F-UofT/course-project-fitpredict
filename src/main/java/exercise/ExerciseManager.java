package exercise;

public class ExerciseManager {

    /**
     * Create new exercise instance without a type
     */
    public Exercise createExercise(String name, float caloriesBurntPerMin) {
        return new Exercise(name, caloriesBurntPerMin);
    }

    /**
     * Delete the passed exercise and return it
     */
    public void deleteExercise(Exercise toBeDeleted) {

    }
}