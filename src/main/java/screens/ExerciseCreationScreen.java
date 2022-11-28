package screens;

// Frameworks & Drivers

import controllers.ExerciseCreationController;
import controllers.UserCreationController;
import use_cases.UserAccountList;
import use_cases.UserCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExerciseCreationScreen extends JFrame implements ActionListener{
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

        JButton back = new JButton("Go Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(this);
        this.add(back);

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
        System.out.println("Click " + e.getActionCommand());
        JComponent jc = (JComponent) e.getSource();
        Window w = SwingUtilities.getWindowAncestor(jc);
        w.dispose();

        UserAccountList users = new UserAccountList();
        UserCreator userCreator = new UserCreator(users);
        UserCreationController userCreationController = new UserCreationController(userCreator);
        UserCreationScreen screen = new UserCreationScreen(userCreationController);
        screen.pack();
        screen.setVisible(true);
    }
}
