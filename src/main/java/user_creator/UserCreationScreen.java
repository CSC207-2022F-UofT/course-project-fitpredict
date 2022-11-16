package user_creator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserCreationScreen extends JFrame implements ActionListener {
    JTextField username = new JTextField(15);
    JTextField password = new JTextField(15);
    JTextField repeatPassword = new JTextField(15);

    public static class LabelTextPanel extends JPanel {
        public LabelTextPanel(JLabel label, JTextField textField) {
            this.add(label);
            this.add(textField);
        }
    }


    UserCreationController userCreationController;

    public UserCreationScreen(UserCreationController controller) {
        this.userCreationController = controller;
        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Choose Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Choose Password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel("Please enter yourpassword again"), repeatPassword);

        JButton signUp = new JButton("Create account");
        JPanel button = new JPanel();
        button.add(signUp);

        signUp.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(usernameInfo);
        panel.add(passwordInfo);
        panel.add(repeatPasswordInfo);
        panel.add(button);
        this.setContentPane(panel);
        this.pack();


        //public void actionPerformed(ActionEvent event) {
            //try {
                //userCreationController.accountCreator(username.getText(), String.valueOf(password.getPassword()));
                //JOptionPane.showMessageDialog(this, "Login successful!");
            //} catch (Exception e) {
                //JOptionPane.showMessageDialog(this, "Login failed!");
            //}
        //}






    }



}
