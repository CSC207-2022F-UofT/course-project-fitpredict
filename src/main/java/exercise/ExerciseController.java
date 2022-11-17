package exercise;

public class ExerciseController {
    /**
     * Create an exercise (would be called from the UI)
     */
    public Exercise createExercise(String name, float caloriesBurntPerMin, ExerciseManager em) {
        return em.createExercise(name, caloriesBurntPerMin);
    }
}
