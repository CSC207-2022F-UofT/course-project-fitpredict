package screens;

import controllers.DataInputController;
import controllers.ExerciseCreationController;
import controllers.UserLoginController;
import use_cases.*;

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
        this.setPreferredSize(new Dimension(300, 250));

        JLabel title1 = new JLabel("1. Create a new exercise");
        title1.setAlignmentX(Component.CENTER_ALIGNMENT);

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

        JLabel title2 = new JLabel("2. Track your workouts");
        title2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton input = new JButton(new AbstractAction("Input exercises") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent jc = (JComponent) e.getSource();
                Window w = SwingUtilities.getWindowAncestor(jc);
                w.dispose();

                DataInputBoundary boundary = new DataInputter();
                DataInputController controller = new DataInputController(boundary);
                DataInputScreen screen = new DataInputScreen(controller, userAccountList);
                screen.pack();
                screen.setVisible(true);
            }
        });
        input.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title3= new JLabel("3. Forecast your weight loss!");
        title3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton predict = new JButton(new AbstractAction("Predict!") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent jc = (JComponent) e.getSource();
                Window w = SwingUtilities.getWindowAncestor(jc);
                w.dispose();

                DashboardScreen screen = new DashboardScreen();
                screen.pack();
                screen.setVisible(true);
            }
        });
        predict.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel spacer = new JLabel("\n");
        spacer.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton back = new JButton("Logout");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(this);
        this.add(back);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title1);
        panel.add(create);
        panel.add(title2);
        panel.add(input);
        panel.add(title3);
        panel.add(predict);
        panel.add(spacer);
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
