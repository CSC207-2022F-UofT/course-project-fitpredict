package exercise;

import entities.Exercise;
import org.junit.jupiter.api.Test;

public class ExerciseTest {
    Exercise e = new Exercise("Push Up", 7);

    @Test
    public void ExerciseCreate() {
        assert (e != null);
    }

    @Test
    public void ExerciseGetName() {
        String expected = "Push Up";
        assert (e.getName().equals(expected));
    }

    @Test
    public void ExerciseGetCaloriesBurnt() {
        double expected = 7;
        assert (e.getCaloriesBurntPerMin() == expected);
    }

    @Test
    public void ExerciseSetName() {
        String expected = "Jumping Jack";
        e.setName(expected);
        assert (e.getName().equals(expected));
    }

    @Test
    public void ExerciseSetCaloriesBurnt() {
        double expected = 10;
        e.setCaloriesBurntPerMin(expected);
        assert (e.getCaloriesBurntPerMin() == expected);
    }
}
