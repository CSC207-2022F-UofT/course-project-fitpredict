package exercise_screens;

import javax.swing.*;
import java.awt.event.*;
import user_login.UserLoginController;
import user_login.UserLoginScreen;

public class ExerciseCreationScreen extends JFrame implements ActionListener {

    public static class LabelTextPanel extends JPanel {
    }

    public UserLoginScreen mystery (UserLoginController controller) {
        return new UserLoginScreen(controller);
    }

    public void actionPerformed(ActionEvent event) {
    }

}