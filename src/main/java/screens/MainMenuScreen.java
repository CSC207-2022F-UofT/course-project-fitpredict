package screens;

import com.sun.tools.javac.Main;
import controllers.ExerciseCreationController;
import controllers.UserLoginController;
import entities.CurrentUser;
import use_cases.ExerciseCreationInteractor;
import use_cases.ExerciseManager;
import use_cases.UserAccountList;
import screens.ExerciseCreationMain;
import use_cases.UserLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen extends JFrame implements ActionListener {
    UserAccountList userAccountList;

    /**
     * The main menu screen with buttons
     */
    public MainMenuScreen(UserAccountList userAccountList) {

        this.userAccountList = userAccountList;
        this.setPreferredSize(new Dimension(300, 300));

        JLabel title = new JLabel("1. Create a new exercise");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton create = new JButton(new AbstractAction("Create Exercise") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent jc = (JComponent) e.getSource();
                Window w = SwingUtilities.getWindowAncestor(jc);
                w.dispose();

                ExerciseCreationController ecc = new ExerciseCreationController(
                        new ExerciseCreationInteractor(new ExerciseManager()));
                ExerciseCreationScreen screen = new ExerciseCreationScreen(ecc, userAccountList);
                screen.pack();
                screen.setVisible(true);
            }
        });
        create.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton back = new JButton("Go Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(this);
        this.add(back);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(title);
        panel.add(create);
        panel.add(back);
        this.setContentPane(panel);
        this.pack();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent jc = (JComponent) e.getSource();
        Window w = SwingUtilities.getWindowAncestor(jc);
        w.dispose();

        UserLogin userLogin = new UserLogin(userAccountList);
        UserLoginController userLoginController = new UserLoginController(userLogin);
        UserLoginScreen userLoginScreen = new UserLoginScreen(userLoginController);
        userLoginScreen.pack();
        userLoginScreen.setVisible(true);
    }
}
