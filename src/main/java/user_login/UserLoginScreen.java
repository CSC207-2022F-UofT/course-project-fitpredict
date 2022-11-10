package user_login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class UserLoginScreen extends JFrame implements ActionListener {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);

    //UserLoginController userLoginController;

    public UserLoginScreen() {
        //this.userLoginController = userLoginController;
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Password"), password);

        JButton logIn = new JButton("Login");
         JPanel button = new JPanel();
         button.add(logIn);

         logIn.addActionListener(this);

         JPanel main = new JPanel();
         main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
         main.add(title);
         main.add(usernameInfo);
         main.add(passwordInfo);
         main.add(button);
         this.setContentPane(main);
         this.pack();

    }
    public void actionPerformed(ActionEvent event) {
        System.out.println("Click" + event.getActionCommand());
    }
}
