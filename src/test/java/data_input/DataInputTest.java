package data_input;
import controllers.DataInputController;
import entities.CurrentUser;
import entities.DataPoint;
import entities.Exercise;
import entities.User;
import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import use_cases.DataInputBoundary;
import use_cases.DataInputter;
import use_cases.ExerciseMap;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataInputTest {
    User u = new User("Josh", "123abc", "123abc",
            62.0, 130.0, "Male", "2006-10-12");
    DataInputBoundary boundary = new DataInputter();
    DataInputController controller = new DataInputController(boundary);
    Exercise e1 = new Exercise("Push Up", 7);
    Exercise e2 = new Exercise("Sit Up", 3);
    Exercise e3 = new Exercise("Running", 12);
    Exercise e4 = new Exercise("Basketball", 9);
    Date d = new Date(DataPoint.convertEpochMilliseconds(9, 22, 2022));

    @Test
    public void testDataInputTestNoExercise() {
        CurrentUser.getInstance().setUser(u);
        CurrentUser cu = CurrentUser.getInstance();
        String[] eNames = new String[0];
        String[] times = new String[0];
        controller.inputData(9, 22, 2022, 150, eNames, times);
        DataPoint actual = cu.getUser().getDataPointMap().getData().get(d);
        DataPoint expected = new DataPoint(9, 22, 2022);
        assertEquals(expected.getDate(), actual.getDate());
        assertEquals(expected.getCaloriesBurnt(), actual.getCaloriesBurnt());
        assertEquals(expected.getExerciseList(), actual.getExerciseList());
    }

    @Test
    public void testDataInputTestOneExercise() {
        CurrentUser.getInstance().setUser(u);
        CurrentUser cu = CurrentUser.getInstance();
        String[] eNames2 = new String[1];
        eNames2[0] = "Push Up";
        String[] times2 = new String[1];
        times2[0] = "10";
        controller.inputData(9, 22, 2022, 150, eNames2, times2);
        DataPoint actual = cu.getUser().getDataPointMap().getData().get(d);
        DataPoint expected = new DataPoint(9, 22, 2022);
        expected.addExercise(e1);
        expected.setCaloriesBurnt(70);
        assertEquals(expected.getDate(), actual.getDate());
        assertEquals(expected.getCaloriesBurnt(), actual.getCaloriesBurnt());
        assertEquals(expected.getExerciseList().get(0).getName(), actual.getExerciseList().get(0).getName());
        assertEquals(expected.getExerciseList().get(0).getCaloriesBurntPerMin(), actual.getExerciseList().get(0).getCaloriesBurntPerMin());
    }

    @Test
    @Order(3)
    public void testDataInputTestManyExercises() {
        CurrentUser.getInstance().setUser(u);
        CurrentUser cu = CurrentUser.getInstance();
        ExerciseMap.addExercise(e1);
        ExerciseMap.addExercise(e2);
        ExerciseMap.addExercise(e3);
        ExerciseMap.addExercise(e4);
        String[] eNames3 = new String[3];
        eNames3[0] = "Sit Up";
        eNames3[1] = "Running";
        eNames3[2] = "Basketball";
        String[] times3 = new String[3];
        times3[0] = "15";
        times3[1] = "30";
        times3[2] = "45";
        controller.inputData(9, 22, 2022, 150, eNames3, times3);
        DataPoint actual = cu.getUser().getDataPointMap().getData().get(d);
        DataPoint expected = new DataPoint(9, 22, 2022);
        expected.addExercise(e2);
        expected.addExercise(e3);
        expected.addExercise(e4);
        expected.setCaloriesBurnt(810);
        assertEquals(expected.getDate(), actual.getDate());
        for (int i = 0; i <= 2; i++) {
            Exercise acExercise = actual.getExerciseList().get(i);
            Exercise exExercise = expected.getExerciseList().get(i);
            assertEquals(exExercise.getCaloriesBurntPerMin(), acExercise.getCaloriesBurntPerMin());
            assertEquals(exExercise.getName(), acExercise.getName());
            assertEquals(expected.getCaloriesBurnt(), actual.getCaloriesBurnt());

            assertEquals(expected.getExerciseList(), actual.getExerciseList());

        }
    }
}
