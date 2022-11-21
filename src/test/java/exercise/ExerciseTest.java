package exercise;

import entities.Exercise;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ExerciseTest {
    Exercise e = new Exercise("Push Up", 7);

    @Test
    public void ExerciseCreate() {
        assert (e != null);
    }

    @Test
    public void ExerciseGetName() {
        assert (e.getName().equals("Push Up"));
    }

    @Test
    public void ExerciseGetCaloriesBurnt() {
        assert (e.getCaloriesBurntPerMin() == 7);
    }

    @Test
    public void ExerciseSetName() {
        e.setName("Jumping Jack");
        assert (e.getName().equals("Jumping Jack"));
    }

    @Test
    public void ExerciseSetCaloriesBurnt() {
        e.setCaloriesBurntPerMin(10);
        assert (e.getCaloriesBurntPerMin() == 10);
    }
}
