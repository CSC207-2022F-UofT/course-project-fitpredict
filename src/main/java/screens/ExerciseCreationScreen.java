package screens;

// Frameworks & Drivers

import controllers.ExerciseCreationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExerciseCreationScreen extends JPanel implements ActionListener{
    JTextField name = new JTextField(15);
    JTextField calories = new JTextField(10);
    ExerciseCreationController ecc;

    /**
     * The "main" screen of exercise creation
     * @param controller The controller object in the interface adapter layer
     */
    public ExerciseCreationScreen(ExerciseCreationController controller) {

        JLabel title = new JLabel("Create New Exercise");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        this.add(new LabelTextPanel(new JLabel("Exercise Name"), name));
        this.add(new LabelTextPanel(new JLabel("Calories Burnt Per Minute"), calories));

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
        create.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(create);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    /**
     * Invoked when an action occurs.
     * Attempt to create a new exercise
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
