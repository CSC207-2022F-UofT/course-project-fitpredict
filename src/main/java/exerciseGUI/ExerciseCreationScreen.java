package exerciseGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ExerciseCreationScreen extends JFrame implements ActionListener{

    public ExerciseCreationScreen() {
        JPanel main = new JPanel();
        main.setBackground(Color.YELLOW);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setPreferredSize(new Dimension(500,500));

        JLabel title = new JLabel("Create New Exercise");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        main.add(title);

//        LabelTextPanel a = new LabelTextPanel(new JLabel("Exercise Name"), new JTextField(15));
//        a.setAlignmentX(Component.RIGHT_ALIGNMENT);
//        LabelTextPanel b = new LabelTextPanel(new JLabel("Calories Burnt Per Min"), new JTextField(15));
//        b.setAlignmentX(Component.RIGHT_ALIGNMENT);

//        JButton create = new JButton("Create Exercise");
//        main.add(create);
//        main.add(a);
//        main.add(b);

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

    }

    public static void main(String[] args) {
        ExerciseCreationScreen ecs = new ExerciseCreationScreen();
        ecs.setVisible(true);
    }
}
