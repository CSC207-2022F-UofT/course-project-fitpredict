package exercise;

import entities.CurrentUser;
import entities.User;
import use_cases.ExerciseCreationInteractor;
import use_cases.ExerciseManager;
import org.junit.jupiter.api.Test;

public class ExerciseCreationInteractorTest {

    @Test
    public void testCreateNewExercise() {
        User u = new User("Alex", "password", "password", 67.0, 170.0, "Male", "2004-11-14");
        CurrentUser.getInstance().setUser(u);
        ExerciseManager em = new ExerciseManager();
        ExerciseCreationInteractor eci = new ExerciseCreationInteractor(em);
        assert (eci.create("Push Up", 7));
    }

    @Test
    public void testTryCreateDuplicateExercise() {
        User u = new User("Alex", "password", "password", 67.0, 170.0, "Male", "2004-11-14");
        CurrentUser.getInstance().setUser(u);
        ExerciseManager em = new ExerciseManager();
        ExerciseCreationInteractor eci = new ExerciseCreationInteractor(em);
        eci.create("Jumping Jack", 7);
        assert (!eci.create("Jumping Jack", 10));
    }
}
