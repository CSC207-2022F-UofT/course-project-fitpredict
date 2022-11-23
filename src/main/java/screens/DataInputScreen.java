package screens;

import controllers.DataInputController;
import entities.CurrentUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.Date;

public class DataInputScreen extends JFrame implements ActionListener {
    JTextField date = new JTextField(15);

    JTextField weight = new JTextField(15);
    JTextField exercises = new JTextField(15);
    JTextField exerciseTimes = new JTextField(15);
    DataInputController dataInputController;

    public DataInputScreen(DataInputController controller) {
        this.dataInputController = controller;
        JLabel title = new JLabel("Data Input Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel dateInfo = new LabelTextPanel(new JLabel("Enter Date (mm/dd/yyyy)"), date);
        LabelTextPanel weightInfo = new LabelTextPanel(new JLabel("Enter your weight"), weight);
        LabelTextPanel exercisesInfo = new LabelTextPanel(new JLabel("Enter the exercises you did (comma seperated)"), exercises);
        LabelTextPanel exerciseTimesInfo = new LabelTextPanel(new JLabel("Enter how long you did each exercise in minutes (comma seperated)"), exerciseTimes);
        JButton inputButton = new JButton("Input Data");
        JPanel button = new JPanel();
        button.add(inputButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(dateInfo);
        panel.add(weightInfo);
        panel.add(exercisesInfo);
        panel.add(exerciseTimesInfo);
        panel.add(button);
        this.setContentPane(panel);
        this.pack();
    }

    public void actionPerformed(ActionEvent evt) {
        if (!(CurrentUser.getInstance().getUser() == null)) {
            String dateString = date.getText();
            int month = Integer.parseInt(dateString.substring(0, 2));
            int day = Integer.parseInt(dateString.substring(3, 5));
            int year = Integer.parseInt(dateString.substring(6));
            LocalDate localDate = LocalDate.of(year, month, day);
            Date dateInput = new Date(localDate.toEpochDay());
            String[] exercisesNames = {exercises.getText()};
            String[] timesStrings = {exerciseTimes.getText()};
            if (!(CurrentUser.getInstance().getDataPointMap().getData().containsKey(dateInput))) {
                dataInputController.inputData(month, day, year, Double.parseDouble(weight.getText()),
                        exercisesNames, timesStrings);
            }
        }
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
