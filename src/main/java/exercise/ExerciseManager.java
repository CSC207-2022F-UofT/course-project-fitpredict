package exercise;

public class ExerciseManager {

    /**
     * Create new exercise instance without a type
     */
    public Exercise createExercise(String name, double caloriesBurntPerMin) {
        if (name.equals("_")) {
            throw new IllegalArgumentException ("An exercise cannot be named _");
        }
        return new Exercise(name, caloriesBurntPerMin);
    }

    public boolean deleteExercise(Exercise toBeDeleted) {
        toBeDeleted.setName("_");
    }
}
