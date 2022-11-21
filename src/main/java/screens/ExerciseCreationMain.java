package screens;

// Frameworks & Drivers

import controllers.ExerciseCreationController;
import entities.User;
import use_cases.ExerciseCreationInteractor;
import use_cases.ExerciseManager;

import javax.swing.*;
import java.awt.*;

public class ExerciseCreationMain {
    /**
     * Create the final GUI
     */
    public static void main(String[] args) {
        User currentUser = User.getCurrentUser();
        ExerciseCreationController ecc = new ExerciseCreationController(
                new ExerciseCreationInteractor(new ExerciseManager(), currentUser));

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