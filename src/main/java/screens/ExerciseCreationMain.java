package screens;

// Frameworks & Drivers

import controllers.ExerciseCreationController;
import entities.CurrentUser;
import entities.User;
import use_cases.ExerciseCreationInteractor;
import use_cases.ExerciseManager;
import use_cases.UserAccountList;

import javax.swing.*;
import java.awt.*;

public class ExerciseCreationMain {
    /**
     * Create the final GUI
     */
    public static void main(String[] args) {
        User sampleUser = new User("selintasman1", "Hello1234", "Hello1234", 15.0, 1.64, "Female", "2002-08-14");
        CurrentUser.getInstance().setUser(sampleUser);
        UserAccountList ual = new UserAccountList();

        ExerciseCreationController ecc = new ExerciseCreationController(
                new ExerciseCreationInteractor(new ExerciseManager()));
        ExerciseCreationScreen screen = new ExerciseCreationScreen(ecc, ual);
        screen.pack();
        screen.setVisible(true);
    }
}
