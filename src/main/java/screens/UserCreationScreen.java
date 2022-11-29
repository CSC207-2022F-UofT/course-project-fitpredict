package screens;

import controllers.UserCreationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserCreationScreen extends JFrame implements ActionListener {
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JPasswordField repeatPassword = new JPasswordField(15);
    JTextField weight = new JTextField(15);
    JTextField height = new JTextField(15);
    JTextField sex = new JTextField(15);
    JTextField birthday = new JTextField(15);

    UserCreationController userCreationController;

    public UserCreationScreen(UserCreationController controller) {
        this.userCreationController = controller;
        JLabel title = new JLabel("Register Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Choose Username (At least 5 characters: must include letters and numbers)"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Choose Password (At least 5 characters: must include letters and numbers)"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel("Please enter your password again"), repeatPassword);
        LabelTextPanel weightInfo = new LabelTextPanel(new JLabel("Enter your weight"), weight);
        LabelTextPanel heightInfo = new LabelTextPanel(new JLabel("Enter your height"), height);
        LabelTextPanel sexInfo = new LabelTextPanel(new JLabel("Enter your gender (Options: Male, Female, Other)"), sex);
        LabelTextPanel birthdayInfo = new LabelTextPanel(new JLabel("Enter your birthday (Use the form: YYYY-MM-DD"), birthday);

        JButton signUp = new JButton("Create Account");
        JPanel button = new JPanel();
        button.add(signUp);

        JButton close = new JButton(new AbstractAction("Close Window") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent jc = (JComponent) e.getSource();
                Window w = SwingUtilities.getWindowAncestor(jc);
                w.dispose();
            }
        });
        JPanel buttonClose = new JPanel();
        buttonClose.add(close);

        signUp.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(usernameInfo);
        panel.add(passwordInfo);
        panel.add(repeatPasswordInfo);
        panel.add(weightInfo);
        panel.add(heightInfo);
        panel.add(sexInfo);
        panel.add(birthdayInfo);
        panel.add(button);
        panel.add(buttonClose);
        this.setContentPane(panel);
        this.pack();
    }

    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, userCreationController.accountCreator(username.getText(), password.getText(), repeatPassword.getText(),
                Double.parseDouble(height.getText()), Double.parseDouble(weight.getText()),
                sex.getText(), birthday.getText()));

    }
}
