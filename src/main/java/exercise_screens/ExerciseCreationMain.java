package exercise_screens;

import exercise.ExerciseCreationInteractor;
import exercise.ExerciseFactory;
import exercise.ExerciseMap;

import javax.swing.*;
import java.awt.*;

public class ExerciseCreationMain {
    public static void main(String[] args) {
        User currentUser = User.getCurrentUser();
        ExerciseMap em = new ExerciseMap();
        ExerciseCreationController ecc = new ExerciseCreationController(
                new ExerciseCreationInteractor(new ExerciseFactory(), em, currentUser));

        JFrame app = new JFrame("Create Exercise");
        CardLayout cl = new CardLayout();
        JPanel screens = new JPanel(cl);

        ExerciseCreationScreen ecs = new ExerciseCreationScreen(ecc);
        screens.add(ecs);

        cl.show(screens, "qmf");
        app.add(screens);
        app.pack();
        app.setVisible(true);
    }
}
