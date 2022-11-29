package screens;

import controllers.UserCreationController;
import use_cases.UserAccountList;
import use_cases.UserCreator;
import use_cases.UserLogin;
import controllers.UserLoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UserLoginScreen extends JFrame implements ActionListener {
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

        JButton logIn = new JButton(new AbstractAction("Login") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JPanel button = new JPanel();
        button.add(logIn);
        logIn.addActionListener(this);
        JButton createUser = new JButton(new AbstractAction("Create New User") {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserCreationScreen screen = new UserCreationScreen(userCreationController);
                screen.pack();
                screen.setVisible(true);
            }
        });
        JPanel button2 = new JPanel();
        button2.add(createUser);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(usernameInfo);
        panel.add(passwordInfo);
        panel.add(button);
        panel.add(button2);
        this.setContentPane(panel);
        this.pack();

    }
    /**
     * Implements what happens once the button is clicked.
     * @param event the event to be processed
     */
    public void actionPerformed(ActionEvent event) {
        UserLogin.LogInResult  result = userLoginController.login(username.getText(), String.valueOf(password.getPassword()));
        switch (result) {
            case LOG:
                JOptionPane.showMessageDialog(this, "Logged in successfully");
                break;
            case NO_LOG:
                JOptionPane.showMessageDialog(this, "Login failed");
                break;
        }
    }
}
