package exercise_screens;

// Frameworks & Drivers

import exercise.ExerciseCreationInteractor;
import exercise.ExerciseManager;
import exercise.ExerciseMap;

import javax.swing.*;
import java.awt.*;

public class ExerciseCreationMain {
    /**
     * Create the final GUI
     */
    public static void main(String[] args) {
        User currentUser = User.getCurrentUser();
        ExerciseMap em = new ExerciseMap();
        ExerciseCreationController ecc = new ExerciseCreationController(
                new ExerciseCreationInteractor(new ExerciseManager(), em, currentUser));

        JFrame app = new JFrame("Create Exercise");
        CardLayout cl = new CardLayout();
        JPanel screens = new JPanel(cl);

        ExerciseCreationScreen ecs = new ExerciseCreationScreen(ecc);
        screens.add(ecs);

        cl.show(screens, "screen");
        app.add(screens);
        app.pack();
        app.setVisible(true);
    }
}
