package screens;

// Frameworks & Drivers

import controllers.ExerciseCreationController;
import use_cases.UserAccountList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExerciseCreationScreen extends JFrame implements ActionListener{
    JTextField name = new JTextField(15);
    JTextField calories = new JTextField(10);
    ExerciseCreationController ecc;

    UserAccountList userAccountList;

    /**
     * The "main" screen of exercise creation
     * @param controller The controller object in the interface adapter layer
     */
    public ExerciseCreationScreen(ExerciseCreationController controller, UserAccountList userAccountList) {
        this.userAccountList = userAccountList;
        JLabel title = new JLabel("Create New Exercise");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel nameField = new LabelTextPanel(new JLabel("Exercise Name"), name);
        LabelTextPanel calorieField = new LabelTextPanel(new JLabel("Calories Burnt Per Minute"), calories);

        JButton create = new JButton(new AbstractAction("Create Exercise") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ecc = controller;
                ResultScreen rs;
                if (name.getText().equals("")) {
                    rs = new ResultScreen("An Exercise cannot have no name!");
                }
                else if (calories.getText().equals("") || Double.parseDouble(calories.getText()) <= 0) {
                    rs = new ResultScreen("An Exercise must burn calories!");
                }
                else {
                    boolean exerciseCreated = ecc.create(name.getText(), Double.parseDouble(calories.getText()));
                    if (exerciseCreated) {
                        rs = new ResultScreen("Exercise added!");
                    } else {
                        rs = new ResultScreen("An Exercise with that name already exists!");
                    }
                }
                rs.setVisible(true);
            }
        });

        JButton back = new JButton("Go Back");
        back.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(create);
        buttons.add(back);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(title);
        panel.add(nameField);
        panel.add(calorieField);
        panel.add(buttons);
        this.setContentPane(panel);
        this.pack();
    }

    /**
     * Invoked when an action occurs.
     * Attempt to create a new exercise
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JComponent jc = (JComponent) e.getSource();
        Window w = SwingUtilities.getWindowAncestor(jc);
        w.dispose();

        MainMenuScreen screen = new MainMenuScreen(this.userAccountList);
        screen.pack();
        screen.setVisible(true);
    }
}
