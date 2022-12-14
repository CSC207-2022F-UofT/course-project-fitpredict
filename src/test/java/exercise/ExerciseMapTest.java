package exercise;

import entities.CurrentUser;
import entities.Exercise;
import entities.User;
import use_cases.ExerciseMap;
import org.junit.jupiter.api.Test;

public class ExerciseMapTest {

    @Test
    public void testCheckUser() {
        User u = new User("Alex", "password", "password", 67.0, 170.0, "Male", "2004-11-14");
        Exercise e =new Exercise("Push Up", 7);
        CurrentUser.getInstance().setUser(u);
        ExerciseMap.addExercise(e);
        assert (ExerciseMap.contains("Alex"));
    }

    @Test
    public void testCheckUserContainsExercise() {
        User u = new User("Alex", "password", "password", 67.0, 170.0, "Male", "2004-11-14");
        Exercise e =new Exercise("Push Up", 7);
        CurrentUser.getInstance().setUser(u);
        ExerciseMap.addExercise(e);
        Exercise expected = e;
        assert (ExerciseMap.get("Alex").contains(expected));
    }
}
