package user_login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UserLoginScreen extends JFrame implements ActionListener {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);

    public static class LabelTextPanel extends JPanel {
        public LabelTextPanel(JLabel label, JTextField textField) {
            this.add(label);
            this.add(textField);
        }
    }

    UserLoginController userLoginController;

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
    public void actionPerformed(ActionEvent event) {
        try {
            userLoginController.login(username.getText(), String.valueOf(password.getPassword()));
            JOptionPane.showMessageDialog(this, "Login successful!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Login failed!");
        }
    }

}
