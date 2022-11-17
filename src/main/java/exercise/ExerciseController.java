package exercise;

public class ExerciseController {
    public Exercise createExercise(String name, float caloriesBurntPerMin, ExerciseManager em) {
        return em.createExercise(name, caloriesBurntPerMin);
    }
}
