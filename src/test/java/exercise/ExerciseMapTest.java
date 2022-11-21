package exercise;

import entities.CurrentUser;
import entities.Exercise;
import entities.User;
import use_cases.ExerciseMap;
import org.junit.jupiter.api.Test;

public class ExerciseMapTest {

    @Test
    public void CheckUser() {
        User u = new User("Alex", "password", "password", 67.0, 170.0, "Male", "2004-11-14");
        Exercise e =new Exercise("Push Up", 7);
        CurrentUser cu = new CurrentUser();
        cu.setUser(u);
        ExerciseMap.addExercise(cu, e);
        assert (ExerciseMap.contains("Alex"));
    }

    @Test
    public void CheckUserContainsExercise() {
        User u = new User("Alex", "password", "password", 67.0, 170.0, "Male", "2004-11-14");
        Exercise e =new Exercise("Push Up", 7);
        CurrentUser cu = new CurrentUser();
        cu.setUser(u);
        ExerciseMap.addExercise(cu, e);
        Exercise expected = e;
        assert (ExerciseMap.get("Alex").contains(expected));
    }
}
