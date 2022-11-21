package screens;

// Frameworks & Drivers

import controllers.ExerciseCreationController;
import use_cases.ExerciseMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExerciseCreationScreen extends JPanel implements ActionListener{
    JTextField name = new JTextField(15);
    JTextField calories = new JTextField(10);
    ExerciseCreationController ecc;
    ExerciseMap em;

    /**
     * The "main" screen of exercise creation
     * @param controller The controller object in the interface adapter layer
     */
    public ExerciseCreationScreen(ExerciseCreationController controller) {
        this.ecc = controller;

        JLabel title = new JLabel("Create New Exercise");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        this.add(new LabelTextPanel(new JLabel("Exercise Name"), name));
        this.add(new LabelTextPanel(new JLabel("Calories Burnt Per Minute"), calories));

        JButton create = new JButton("Create Exercise");
        create.setAlignmentX(Component.CENTER_ALIGNMENT);
        create.addActionListener(this);
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
        boolean exerciseCreated = this.ecc.create(name.getText(), Double.parseDouble(calories.getText()));
    }

}
