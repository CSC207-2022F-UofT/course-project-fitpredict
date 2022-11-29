package screens;

// Frameworks & Drivers

import controllers.ExerciseCreationController;
import entities.CurrentUser;
import entities.User;
import use_cases.ExerciseCreationInteractor;
import use_cases.ExerciseManager;

import javax.swing.*;
import java.awt.*;

public class ExerciseCreationMain {
    /**
     * Create the final GUI
     */
    public static void generateExerciseCreationGUI(CurrentUser currentUser) {
        ExerciseCreationController ecc = new ExerciseCreationController(
                new ExerciseCreationInteractor(new ExerciseManager()));

        JFrame app = new JFrame("Create Exercise");
        CardLayout cl = new CardLayout();
        JPanel screens = new JPanel(cl);

        //ExerciseCreationScreen ecs = new ExerciseCreationScreen(ecc);
        //screens.add(ecs);

        cl.show(screens, "screen");
        app.add(screens);
        app.pack();
        app.setVisible(true);
    }

    public static void main(String[] args) {
        User sampleUser = new User("selintasman1", "Hello1234", "Hello1234", 15.0, 1.64, "Female", "2002-08-14");
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUser(sampleUser);
        generateExerciseCreationGUI(currentUser);
    }
}
