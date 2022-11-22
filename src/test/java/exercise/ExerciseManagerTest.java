package exercise;

import entities.Exercise;
import use_cases.ExerciseManager;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThrows;

public class ExerciseManagerTest {

    @Test
    public void NameInvalidExercise() {
        ExerciseManager em = new ExerciseManager();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {em.createExercise("_", 10);});
        String expected = "An exercise cannot be named _";
        assert (exception.getMessage().equals(expected));
    }

    @Test void DeleteExercise() {
        ExerciseManager em = new ExerciseManager();
        Exercise exercise = new Exercise("Push Up", 7);
        em.deleteExercise(exercise);
        String expected = "_";
        assert (exercise.getName().equals(expected));
    }
}
