package screens;


import controllers.DataInputController;
import entities.CurrentUser;
import entities.DataPoint;
import entities.Exercise;
import entities.User;
import use_cases.DataInputter;
import use_cases.DataInputBoundary;
import use_cases.ExerciseMap;


public class DataInputScreenMain {
    /**
     * Creates the DataInputScreen
     */
    public static void main(String[] args) {
        User sampleUser = new User("selintasman1", "Hello1234", "Hello1234", 15.0, 1.64, "Female", "2002-08-14");
        CurrentUser cu = CurrentUser.getInstance();
        cu.setUser(sampleUser);
        Exercise sampleExercise = new Exercise("Push Up", 7);
        ExerciseMap.addExercise(cu, sampleExercise);
        DataPoint sampleDataPoint = new DataPoint(10, 10, 2000);
        cu.getUser().getDataPointMap().addDataPoint(sampleDataPoint);
        DataInputBoundary boundary = new DataInputter();
        DataInputController controller = new DataInputController(boundary);
        DataInputScreen screen = new DataInputScreen(controller);
        screen.pack();
        screen.setVisible(true);
    }
}