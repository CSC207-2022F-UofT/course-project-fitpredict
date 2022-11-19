package exercise_screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultScreen extends JFrame implements ActionListener {

    public ResultScreen(String text) {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setPreferredSize(new Dimension(200, 40));

        JLabel title = new JLabel(text);
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
        System.out.println("Click " + e.getActionCommand());
        this.dispose();
    }

//    public static void main(String[] args) {
//        ResultScreen ecs = new ResultScreen();
//        ecs.setVisible(true);
//    }
}
