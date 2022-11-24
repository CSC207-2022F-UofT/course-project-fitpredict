package screens;


import controllers.DataInputController;
import entities.CurrentUser;
import entities.User;
import use_cases.DataInputter;
import use_cases.DataInputBoundary;

public class DataInputScreenMain {
    /**
     * Creates the DataInputScreen
     */
    public static void main(String[] args) {
        User sampleUser = new User("selintasman1", "Hello1234", "Hello1234", 15.0, 1.64, "Female", "2002-08-14");
        CurrentUser.getInstance().setUser(sampleUser);
        DataInputBoundary boundary = new DataInputter();
        DataInputController controller = new DataInputController(boundary);
        DataInputScreen screen = new DataInputScreen(controller);
        screen.pack();
        screen.setVisible(true);
    }
}