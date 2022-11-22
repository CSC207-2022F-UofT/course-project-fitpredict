package exercise;

import entities.Exercise;
import org.junit.jupiter.api.Test;

public class ExerciseTest {

    @Test
    public void ExerciseCreate() {
        Exercise e = new Exercise("Push Up", 7);
        assert (e != null);
    }

    @Test
    public void ExerciseGetName() {
        Exercise e = new Exercise("Push Up", 7);
        String expected = "Push Up";
        assert (e.getName().equals(expected));
    }

    @Test
    public void ExerciseGetCaloriesBurnt() {
        Exercise e = new Exercise("Push Up", 7);
        double expected = 7;
        assert (e.getCaloriesBurntPerMin() == expected);
    }

    @Test
    public void ExerciseSetName() {
        Exercise e = new Exercise("Push Up", 7);
        String expected = "Jumping Jack";
        e.setName(expected);
        assert (e.getName().equals(expected));
    }

    @Test
    public void ExerciseSetCaloriesBurnt() {
        Exercise e = new Exercise("Push Up", 7);
        double expected = 10;
        e.setCaloriesBurntPerMin(expected);
        assert (e.getCaloriesBurntPerMin() == expected);
    }
}
