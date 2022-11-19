package exercise_screens;

import exercise.ExerciseMap;

import javax.swing.*;
import java.awt.*;

public class ExerciseCreationMain {
    public static void main(String[] args) {
        ExerciseMap em = new ExerciseMap();

        JFrame app = new JFrame("Create Exercise");
        CardLayout cl = new CardLayout();
        JPanel screens = new JPanel(cl);

        ExerciseCreationScreen ecs = new ExerciseCreationScreen();
        screens.add(ecs);

        cl.show(screens, "qmf");
        app.add(screens);
        app.pack();
        app.setVisible(true);
    }
}
