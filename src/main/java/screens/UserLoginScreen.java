package screens;

import controllers.UserCreationController;
import use_cases.UserAccountList;
import use_cases.UserCreator;
import controllers.UserLoginController;
import use_cases.UserLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UserLoginScreen extends JFrame implements ActionListener, WindowCloser {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);


    UserLoginController userLoginController;

    /**
     * Creates a User Interface with a button in order to log in.
     * @param controller The controller used by the UI.
     */
    public UserLoginScreen(UserLoginController controller) {
        this.userLoginController = controller;
        UserAccountList userAccountList = this.userLoginController.getUserAccountList();
        UserCreator userCreator = new UserCreator(userAccountList);
        UserCreationController userCreationController = new UserCreationController(userCreator);

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Password"), password);

        JButton logIn = new JButton("Login");
        JPanel buttons = new JPanel();
        buttons.add(logIn);
        logIn.addActionListener(this);

        JButton createUser = new JButton(new AbstractAction("Create New User") {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCreationScreen screen = new UserCreationScreen(userCreationController);
                screen.pack();
                screen.setVisible(true);
            }
        });
        buttons.add(createUser);

        JButton quit = new JButton(new AbstractAction("Quit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel buttonQuit = new JPanel();
        buttonQuit.add(quit);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(usernameInfo);
        panel.add(passwordInfo);
        panel.add(buttons);
        panel.add(buttonQuit);
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
        UserLogin.LogInResult result = userLoginController.login(username.getText(),
                String.valueOf(password.getPassword()));
        switch (result) {
            case LOG:
                JOptionPane.showMessageDialog(this, "Logged in successfully");

                closeWindow(e);

                MainMenuScreen screen = new MainMenuScreen(this.userLoginController.getUserAccountList());
                screen.pack();
                screen.setVisible(true);
                break;
            case NO_LOG:
                JOptionPane.showMessageDialog(this, "Login failed");
                break;
        }
    }
}
