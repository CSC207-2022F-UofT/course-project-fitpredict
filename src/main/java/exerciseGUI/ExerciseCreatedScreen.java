package exerciseGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExerciseCreatedScreen extends JFrame implements ActionListener {

    public ExerciseCreatedScreen() {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setPreferredSize(new Dimension(200, 40));

        JLabel title = new JLabel("New Exercise Created!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(title);

        JButton exit = new JButton("Okay");
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.addActionListener(this);
        main.add(exit);

        this.setContentPane(main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0); //THIS IS TOO STRONG AND CLOSES THE ENTIRE PROGRAM, NOT JUST THE WINDOW
    }

    public static void main(String[] args) {
        ExerciseCreatedScreen ecs = new ExerciseCreatedScreen();
        ecs.setVisible(true);
    }
}
