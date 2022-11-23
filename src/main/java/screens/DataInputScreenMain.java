package screens;


import controllers.DataInputController;
import use_cases.DataInputter;
import use_cases.DataInputBoundary;

public class DataInputScreenMain {
    /**
     * Creates the DataInputScreen
     */
    public static void main(String[] args) {
        DataInputBoundary boundary = new DataInputter();
        DataInputController controller = new DataInputController(boundary);
        DataInputScreen screen = new DataInputScreen(controller);
        screen.pack();
        screen.setVisible(true);
    }
}