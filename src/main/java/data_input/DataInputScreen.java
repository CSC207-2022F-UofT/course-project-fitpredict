package data_input;

import javax.swing.*;
import java.awt.*;

public class DataInputScreen extends JFrame {
    String[] allExercises = {"push-ups", "sit-ups", "running"};
    JTextField month = new JTextField(5);
    JTextField day = new JTextField(5);
    JTextField year = new JTextField(5);
    JTextField caloriesBurnt = new JTextField(5);
    JList<String> exercises = new JList<String>(allExercises);
    DataInputController controller;

    /**
     *
     */

    public DataInputScreen(DataInputController controller) {
        this.controller = controller;
        JLabel title = new JLabel("Data Input Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel usernameInfo = new LabelTextPanel(new JLabel("Choose Username (At least 5 characters: must include letters and numbers)"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(new JLabel("Choose Password (At least 5 characters: must include letters and numbers)"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(new JLabel("Please enter your password again"), repeatPassword);
        LabelTextPanel weightInfo = new LabelTextPanel(new JLabel("Enter your weight"), weight);
        LabelTextPanel heightInfo = new LabelTextPanel(new JLabel("Enter your height"), height);
        LabelTextPanel sexInfo = new LabelTextPanel(new JLabel("Enter your gender (Options: Male, Female, Other)"), sex);
        LabelTextPanel birthdayInfo = new LabelTextPanel(new JLabel("Enter your birthday (Use the form: YYYY-MM-DD"), birthday);

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
        panel.add(weightInfo);
        panel.add(heightInfo);
        panel.add(sexInfo);
        panel.add(birthdayInfo);
        panel.add(button);
        this.setContentPane(panel);
        this.pack();

    }
}