package exercise_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExerciseCreationScreen extends JPanel implements ActionListener{

    public ExerciseCreationScreen() {

        JLabel title = new JLabel("Create New Exercise");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        this.add(new LabelTextPanel(new JLabel("Exercise Name"), new JTextField(15)));
        this.add(new LabelTextPanel(new JLabel("Calories Burnt Per Minute"), new JTextField(10)));

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
        ExerciseCreatedScreen ecs = new ExerciseCreatedScreen();
        ecs.setVisible(true);
    }

}
