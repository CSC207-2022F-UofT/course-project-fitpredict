package exercise;

import entities.CurrentUser;
import entities.User;
import use_cases.ExerciseCreationInteractor;
import use_cases.ExerciseManager;
import org.junit.jupiter.api.Test;

public class ExerciseCreationInteractorTest {

    @Test
    public void CreateNewExercise() {
        User u = new User("Alex", "password", "password", 67.0, 170.0, "Male", "2004-11-14");
        CurrentUser cu = new CurrentUser();
        cu.setUser(u);
        ExerciseManager em = new ExerciseManager();
        ExerciseCreationInteractor eci = new ExerciseCreationInteractor(em, cu);
        assert (eci.create("Push Up", 7));
    }

    @Test
    public void TryCreateDuplicateExercise() {
        User u = new User("Alex", "password", "password", 67.0, 170.0, "Male", "2004-11-14");
        CurrentUser cu = new CurrentUser();
        cu.setUser(u);
        ExerciseManager em = new ExerciseManager();
        ExerciseCreationInteractor eci = new ExerciseCreationInteractor(em, cu);
        eci.create("Push Up", 7);
        assert (!eci.create("Push Up", 10));
    }
}
