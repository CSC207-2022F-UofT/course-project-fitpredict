package screens;

import controllers.DataInputController;
import entities.CurrentUser;
import entities.DataPoint;
import use_cases.DataPointMap;
import use_cases.ExerciseMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class DataInputScreen extends JFrame implements ActionListener {
    JTextField date = new JTextField(15);

    JTextField weight = new JTextField(15);
    JTextField exercises = new JTextField(15);
    JTextField exerciseTimes = new JTextField(15);
    DataInputController dataInputController;


    /**
     * Creates the UI to input data
     *
     * @param controller The controller used by the UI
     */
    public DataInputScreen(DataInputController controller) {
        this.dataInputController = controller;
        JLabel title = new JLabel("Data Input Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTextPanel dateInfo = new LabelTextPanel(new JLabel("Enter Date (mm/dd/yyyy)"), date);
        LabelTextPanel weightInfo = new LabelTextPanel(new JLabel("Enter your weight"), weight);
        LabelTextPanel exercisesInfo = new LabelTextPanel(new JLabel("Enter the exercises you did (comma seperated)"), exercises);
        LabelTextPanel exerciseTimesInfo = new LabelTextPanel(new JLabel("Enter how long you did each exercise in minutes (comma seperated)"), exerciseTimes);
        JButton inputButton = new JButton("Input Data");
        JButton backButton = new JButton("Main Menu");
        JPanel buttons = new JPanel();
        buttons.add(inputButton);
        buttons.add(backButton);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton back = new JButton(new AbstractAction("Go back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent jc = (JComponent) e.getSource();
                Window w = SwingUtilities.getWindowAncestor(jc);
                w.dispose();
            }
        });
        JPanel backButton = new JPanel();
        backButton.add(back);

        inputButton.addActionListener(this);
        backButton.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(dateInfo);
        panel.add(weightInfo);
        panel.add(exercisesInfo);
        panel.add(exerciseTimesInfo);
        panel.add(button);
        panel.add(backButton);
        panel.add(buttons);
        this.setContentPane(panel);
        this.pack();
    }

    /**
     * Implements what happens once the input data button is clicked.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Main Menu")) {
            JOptionPane.showMessageDialog(this, "This would " +
                    "return back to the main menu screen");
        } else {
            String dateString = date.getText();
            int month = Integer.parseInt(dateString.substring(0, 2));
            int day = Integer.parseInt(dateString.substring(3, 5));
            int year = Integer.parseInt(dateString.substring(6));
            double weightInput = Double.parseDouble(weight.getText());
            String[] exercisesNames = {exercises.getText()};
            String[] timesStrings = {exerciseTimes.getText()};
            inputDataResult(month, day, year, weightInput, exercisesNames, timesStrings);
        }
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
        System.out.println(dataPointMap.getDataPoint(dateInput));
        if (!(ExerciseMap.contains(CurrentUser.getInstance().getUsername()))) {
            rs = new ResultScreen("There are no created exercises");
        } else if (dataPointMap.getData().containsKey(dateInput)) {
            rs = new ResultScreen("There is already data inputted for this day");
        } else if (weightInput <= 0) {
            rs = new ResultScreen("Please enter a valid weight");
        } else {
            dataInputController.inputData(month, day, year, weightInput, exercisesNames, timesStrings);
            rs = new ResultScreen("Data Inputted Successfully");
        }
        rs.setVisible(true);
    }
}
