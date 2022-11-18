package user_login;

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
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Password"), password);

        JButton logIn = new JButton("Login");
        JPanel button = new JPanel();
        button.add(logIn);

        logIn.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(usernameInfo);
        panel.add(passwordInfo);
        panel.add(button);
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
