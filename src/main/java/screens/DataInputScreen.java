package screens;

import controllers.DataInputController;
import entities.CurrentUser;
import entities.DataPoint;
import use_cases.DataPointMap;
import use_cases.ExerciseMap;
import use_cases.UserAccountList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class DataInputScreen extends JFrame implements ActionListener, WindowCloser {
    JTextField date = new JTextField(15);

    JTextField weight = new JTextField(15);
    JTextField exercises = new JTextField(15);
    JTextField exerciseTimes = new JTextField(15);
    DataInputController dataInputController;
    UserAccountList userAccountList;


    /**
     * Creates the UI to input data
     *
     * @param controller The controller used by the UI
     */
    public DataInputScreen(DataInputController controller, UserAccountList userAccountList) {
        this.dataInputController = controller;
        this.userAccountList = userAccountList;
        JLabel title = new JLabel("Data Input Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel dateInfo = new LabelTextPanel(new JLabel("Enter Date (mm/dd/yyyy)"), date);
        LabelTextPanel weightInfo = new LabelTextPanel(new JLabel("Enter your weight (kg)"), weight);
        LabelTextPanel exercisesInfo = new LabelTextPanel(new JLabel("Enter the exercises you did (comma seperated)"), exercises);
        LabelTextPanel exerciseTimesInfo = new LabelTextPanel(new JLabel("Enter how long you did each exercise in minutes (comma seperated)"), exerciseTimes);
        JButton inputButton = new JButton("Input Data");
        JPanel buttons = new JPanel();
        buttons.add(inputButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton back = new JButton(new AbstractAction("Go back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow(e);

                MainMenuScreen screen = new MainMenuScreen(userAccountList);
                screen.pack();
                screen.setVisible(true);
            }
        });
        buttons.add(back);

        inputButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(dateInfo);
        panel.add(weightInfo);
        panel.add(exercisesInfo);
        panel.add(exerciseTimesInfo);
        panel.add(buttons);
        this.setContentPane(panel);
        this.pack();
    }

    /**
     * Implements what happens once the input data button is clicked.
     */
    public void actionPerformed(ActionEvent evt) {
        String dateString = date.getText();
        String[] exercisesNames;
        String[] timesStrings;
        if (exercises.getText().isEmpty()) {exercisesNames = new String[0];}
        else {exercisesNames = exercises.getText().split(",");}
        if (exerciseTimes.getText().isEmpty()) {timesStrings = new String[0];}
        else {timesStrings = exerciseTimes.getText().split(",");}
        try {
            int month = Integer.parseInt(dateString.substring(0, 2));
            int day = Integer.parseInt(dateString.substring(3, 5));
            int year = Integer.parseInt(dateString.substring(6));
            double weightInput = Double.parseDouble(weight.getText());
            if (weightInput <= 0) {throw new IllegalArgumentException();}
            inputDataResult(month, day, year, weightInput, exercisesNames, timesStrings);
        } catch (Exception e) {
            ResultScreen rs = new ResultScreen("Date or Weight is Invalid");
            rs.setVisible(true);}
    }
    /**
     * Helper method for actionPerformed.
     * Creates the ResultScreen after the input data button is pushed
     */
    public void inputDataResult(int month, int day, int year,
                                double weightInput, String[] exercisesNames, String[] timesStrings) {
        ResultScreen rs;
        DataPointMap dataPointMap = CurrentUser.getInstance().getUser().getDataPointMap();
        Date dateInput = new Date(DataPoint.convertEpochMilliseconds(month, day, year));
        boolean existed = false;
        if (!(ExerciseMap.contains(CurrentUser.getInstance().getUser().getUsername()))) {
            rs = new ResultScreen("There are no created exercises");
        } else {
            if (dataPointMap.getData().containsKey(dateInput)) {
                existed = true;}
            if (this.dataInputController.inputData(month, day, year, weightInput, exercisesNames, timesStrings)) {
                if (existed) {rs = new ResultScreen("Data Updated Successfully");
                } else {rs = new ResultScreen("Data Inputted Successfully");}
            } else {rs = new ResultScreen("Invalid exercise inputted");}
        }
        rs.setVisible(true);}
}
