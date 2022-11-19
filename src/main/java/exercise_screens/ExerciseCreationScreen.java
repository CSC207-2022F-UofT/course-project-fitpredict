package exercise_screens;

import exercise.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExerciseCreationScreen extends JPanel implements ActionListener{
    /**
     * The name of the exercise
     */
    JTextField name = new JTextField(15);
    /**
     * The number of calories burnt per minute by the exercise
     */
    JTextField calories = new JTextField(10);

    ExerciseMap em;
    public ExerciseCreationScreen() {

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
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());

        ExerciseFactory ef = new ExerciseFactory();
        Exercise
        em.addExercise(currentUser, )

        ExerciseCreatedScreen ecs = new ExerciseCreatedScreen();
        ecs.setVisible(true);
    }

}
