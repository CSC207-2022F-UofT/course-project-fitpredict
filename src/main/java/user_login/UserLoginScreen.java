package user_login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// This is for the GUI.
public class UserLoginScreen extends JFrame implements ActionListener {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);

    public UserLoginScreen() {
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Password"), password);

        JButton logIn = new JButton("Login");
         JPanel button = new JPanel();
         button.add(logIn);

    }

}
