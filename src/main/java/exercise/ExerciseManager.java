package exercise;

public class ExerciseManager {

    /**
     * Create new exercise instance without a type
     */
    public Exercise createExercise(String name, int caloriesBurntPerMin) {
        Exercise newExercise = new Exercise(name, caloriesBurntPerMin);
        return newExercise;
    }

    /**
     * Create new exercise instance with a type
     */
    public Exercise createExercise(String name, String type, int caloriesBurntPerMin) {
        Exercise newExercise = new Exercise(name, type, caloriesBurntPerMin);
        return newExercise;
    }
}
