package exercise;

import entities.Exercise;
import org.junit.jupiter.api.Test;

public class ExerciseTest {

    @Test
    public void testExerciseCreate() {
        Exercise e = new Exercise("Push Up", 7);
        assert (e != null);
    }

    @Test
    public void testExerciseGetName() {
        Exercise e = new Exercise("Push Up", 7);
        String expected = "Push Up";
        assert (e.getName().equals(expected));
    }

    @Test
    public void testExerciseGetCaloriesBurnt() {
        Exercise e = new Exercise("Push Up", 7);
        double expected = 7;
        assert (e.getCaloriesBurntPerMin() == expected);
    }

    @Test
    public void testExerciseSetName() {
        Exercise e = new Exercise("Push Up", 7);
        String expected = "Jumping Jack";
        e.setName(expected);
        assert (e.getName().equals(expected));
    }

    @Test
    public void testExerciseSetCaloriesBurnt() {
        Exercise e = new Exercise("Push Up", 7);
        double expected = 10;
        e.setCaloriesBurntPerMin(expected);
        assert (e.getCaloriesBurntPerMin() == expected);
    }
}
